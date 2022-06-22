package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.dtoClasses.CustomerDetailsDto;
import com.Ecommerce.Backend.Application.dtoClasses.SellerDetailsDto;
import com.Ecommerce.Backend.Application.entities.Customer;
import com.Ecommerce.Backend.Application.entities.Seller;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.CustomerRepository;
import com.Ecommerce.Backend.Application.repository.SellerRepository;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private EmailSenderService senderService;
    @Autowired
    UserRepository userRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    SellerRepository sellerRepo;


    public ResponseEntity<Object> activateUser(String username)
    {
        User user=userRepo.findByEmail(username);

        if(user!=null){

            if(user.getIs_Active())
                return ResponseHandler.generateResponse3("User is Already Activated !!!!", HttpStatus.OK, "null");
            user.setIs_Active(Boolean.TRUE);
            userRepo.save(user);

            senderService.sendMail(username,"Activation of Account !!!","Your Account is Activated Successfully please Login to use the Application services");

            return ResponseHandler.generateResponse3("User Activated Successfully !!!!", HttpStatus.OK, "null");


        }
        else
            return ResponseHandler.generateResponse3("User Not Found by given Username !!!! ", HttpStatus.BAD_REQUEST, "null");

    }

    public ResponseEntity<Object> deActivateUser(String username)
    {
        if(username.equals("saquibmohd458@gmail.com"))
            return ResponseHandler.generateResponse3("You Don't Deactivate the Main admin user !!!! ", HttpStatus.OK, "null");

        User user=userRepo.findByEmail(username);

        if(user!=null){

            if(!user.getIs_Active())
                return ResponseHandler.generateResponse3("User is Already deActivated !!!!", HttpStatus.OK, "null");
            user.setIs_Active(Boolean.FALSE);
            userRepo.save(user);
            senderService.sendMail(username,"deActivation of Account !!!","Your Account is deActivated for some reason please contact to admin to reActivate your account");

            return ResponseHandler.generateResponse3("User deActivated Successfully !!!!", HttpStatus.OK, "null");


        }
        else
            return ResponseHandler.generateResponse3("User Not Found by given Username !!!! ", HttpStatus.BAD_REQUEST, "null");

    }

    public ResponseEntity<Object> listOfCustomers()
    {
        List<Customer> customerList=customerRepo.findAll();

        if(customerList.isEmpty())
            return ResponseHandler.generateResponse3("No customer register yet !!!! ", HttpStatus.NO_CONTENT, "null");

        List<CustomerDetailsDto> CustomerDetailsDtos =new ArrayList<>();
        for (Customer customer:customerList
             ) {
            CustomerDetailsDtos.add(customer.list());

        }
        return ResponseHandler.generateResponse("Customers List ", HttpStatus.OK, CustomerDetailsDtos);



    }


    public ResponseEntity<Object> listOfSellers() {

    List<Seller> sellerList=sellerRepo.findAll();

    if(sellerList.isEmpty())
        return ResponseHandler.generateResponse3("No Seller register yet !!!! ", HttpStatus.NO_CONTENT, "null");

    List<SellerDetailsDto> SellerDetailsDtos =new ArrayList<>();

    for(Seller seller:sellerList)
    {
        SellerDetailsDtos.add(seller.list());
    }

        return ResponseHandler.generateResponse("Sellers List ", HttpStatus.OK, SellerDetailsDtos);



    }
}
