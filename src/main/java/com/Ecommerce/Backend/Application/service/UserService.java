package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.dtoClasses.CustomerDto;
import com.Ecommerce.Backend.Application.dtoClasses.SellerDto;
import com.Ecommerce.Backend.Application.dtoClasses.UserDto;
import com.Ecommerce.Backend.Application.entities.*;
import com.Ecommerce.Backend.Application.repository.RoleRepository;
import com.Ecommerce.Backend.Application.repository.SellerRepository;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.repository.ProductRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import com.Ecommerce.Backend.Application.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
     Validation validation;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    AddUserDetailsService addUserDetailsService;

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    SellerRepository sellerRepo;



    public ResponseEntity<Object> registerUser(UserDto dto)
    {
        List<String> list = new ArrayList<>();
        String str;
        Boolean bool;

        bool=validation.isValidPassword(dto.getPassword());
        if(bool==false)
            return ResponseHandler.generateResponse3("Password should contain atLeast 8 characters and  '1 uppercase' '1 lowercase'  ' 1 special character ' and ' 1 numeric digit' !!!!!!!", HttpStatus.NOT_ACCEPTABLE, "null");

        str = validation.matchesPasswordAndConfirmPassword(dto);
        if(str!=null)
            return ResponseHandler.generateResponse3(str, HttpStatus.NOT_ACCEPTABLE,"null") ;



        str = validation.checkMailIsUnique(dto);
        if(str!=null)
            return ResponseHandler.generateResponse3(str, HttpStatus.NOT_ACCEPTABLE,"null") ;

         if(dto.getPhone_number()==null&&dto.getCompany_contact()==null)
             return ResponseHandler.generateResponse3("Contact number not be null !!!", HttpStatus.NOT_ACCEPTABLE,"null") ;



        if(dto.getPhone_number()!=null) {
            bool = validation.isValidMobileNo(dto.getPhone_number());
            if (bool == false)
                return ResponseHandler.generateResponse3("Mobile number is not valid", HttpStatus.NOT_ACCEPTABLE,"null") ;

        }

         bool= validation.isValidEmail(dto.getEmail());
        if(bool==false)
            return ResponseHandler.generateResponse3("Email is not valid", HttpStatus.NOT_ACCEPTABLE,"null") ;



        if(dto.getCompany_contact()!=null)
        {
            bool=validation.isValidMobileNo(dto.getCompany_contact());
            if(bool==false)
                return ResponseHandler.generateResponse3("Company contact is not valid", HttpStatus.NOT_ACCEPTABLE,"null") ;


            if(!(Objects.isNull(sellerRepo.findByGst(dto.getGst()))))
                return ResponseHandler.generateResponse3("Please enter unique GST number", HttpStatus.NOT_ACCEPTABLE,"null") ;


           if(!(Objects.isNull(sellerRepo.findBycompany_name(dto.getCompany_name()))))
               return ResponseHandler.generateResponse3("please enter unique company name because given company name is already registered", HttpStatus.BAD_REQUEST,"null") ;


                if(dto.getCompany_name()==null)
                    return ResponseHandler.generateResponse3("Company name not be empty", HttpStatus.NOT_ACCEPTABLE,"null") ;

        }


            return addUserDetailsService.addUserDetails(dto);



    }



//    public ResponseEntity<Object> login()
//    {
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//
//        if(authentication==null || !authentication.isAuthenticated())
//            return null;
//        else {
//            User user = (User) authentication.getPrincipal();
//
//            return ResponseHandler.generateResponse3("Login Successfully !!!!", HttpStatus.OK,"null") ;
//        }
//
//    }

    public ResponseEntity<Object> userDetails()
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();


            if (user.getSeller() != null) {
                SellerDto result=user.sellerDetails();
                return ResponseHandler.generateResponse("Details of seller", HttpStatus.OK, result);
            }
            else {

                CustomerDto result = user.customerDetails();
                return ResponseHandler.generateResponse("Details of Customer", HttpStatus.OK, result);

            }

        }

    }

    public ResponseEntity<Object> updateProfile(UserDto dto)
    {

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();

            if (dto.getFirstName() != null)
                user.setFirstName(dto.getFirstName());
            if (dto.getMiddleName() != null)
                user.setMiddleName(dto.getMiddleName());
            if (dto.getLastName() != null)
                user.setLastName(dto.getLastName());
            if (dto.getPhone_number() != null) {
                boolean bool = validation.isValidMobileNo(dto.getPhone_number());
                if (bool == false)
                    return ResponseHandler.generateResponse3("Please enter valid mobile number", HttpStatus.BAD_REQUEST, "null");
                else
                    user.getCustomer().setContact(dto.getPhone_number());
            } else {
                if (dto.getGst() != null)
                    user.getSeller().setGst(dto.getGst());
                if (dto.getCompany_name() != null) {
                    if (!(Objects.isNull(sellerRepo.findBycompany_name(dto.getCompany_name()))))
                        return ResponseHandler.generateResponse3("please enter unique company name because given company name is already registered"
                                , HttpStatus.BAD_REQUEST, "null");
                    user.getSeller().setCompany_name(dto.getCompany_name());
                }
                if (dto.getCompany_contact() != null) {
                    boolean bool = validation.isValidMobileNo(dto.getCompany_contact());
                    if (bool == false)
                        return ResponseHandler.generateResponse3("Please enter valid contact number", HttpStatus.BAD_REQUEST, "null");
                    else
                        user.getSeller().setCompany_contact(dto.getCompany_contact());

                }
            }


            userRepo.save(user);

            return ResponseHandler.generateResponse3("Profile details updated successfully", HttpStatus.OK, "null");

        }
    }

    public ResponseEntity<Object> updatePassword(UserDto dto)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();

            boolean bool = validation.isValidPassword(dto.getPassword());
            if (bool == true) {
                bool = dto.getPassword().equals(dto.getConfirm_password());
                if (bool == true) {
                    user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

                    userRepo.save(user);
                } else
                    return ResponseHandler.generateResponse3("Password and confirmPassword not Matched", HttpStatus.BAD_REQUEST, "null");

            } else {
                return ResponseHandler.generateResponse3("Password must contain min. 8 characters 1 upperCase, 1 lowerCase, 1 special character and 1 numeric digit", HttpStatus.BAD_REQUEST, "null");

            }
            return ResponseHandler.generateResponse3("Password updated successfully", HttpStatus.OK, "null");
        }


    }


    public ResponseEntity<Object> viewProduct(long productId)
    {
        if(productRepo.findById(productId)==null)
            return  ResponseHandler.generateResponse3("No product found for a given id !!!! ", HttpStatus.BAD_REQUEST, "null");

        Product product=productRepo.findById(productId);

        return  ResponseHandler.generateResponse("Product Details !!!! ", HttpStatus.OK, product);

    }

    public ResponseEntity<Object> viewAllProduct()
    {
        if(productRepo.findAll().isEmpty())
            return  ResponseHandler.generateResponse3("No product found to display !!!! ", HttpStatus.BAD_REQUEST, "null");

        List<Product> productList= productRepo.findAll();

        return  ResponseHandler.generateResponse("Product Details !!!! ", HttpStatus.OK, productList);

    }





}
