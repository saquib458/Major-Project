package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.dtoClasses.addressDto;
import com.Ecommerce.Backend.Application.entities.Address;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.AddressRepository;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class customerService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AddressRepository addressRepo;

    public ResponseEntity<Object> addNewAddress(addressDto dto)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();

            Address address=new Address();

            address.setAddress_line(dto.getAddress_line());
            address.setCity(dto.getCity());
            address.setState(dto.getState());
            address.setCountry(dto.getCountry());
            address.setLabel(dto.getLabel());
            address.setZip_code(dto.getZip_code());
            address.setUser(user);

            Set<Address> addressSet = new HashSet<>();
            addressSet.add(address);

            user.setAddresses(addressSet);

            userRepo.save(user);

            return ResponseHandler.generateResponse3("Address Added successfully !!!", HttpStatus.OK, "null");


        }

    }

    public ResponseEntity<Object> viewAddresses()
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();

            Set<Address> addresses = addressRepo.findByUserId(user.getId());

            if(addresses.isEmpty())
            {
                return ResponseHandler.generateResponse3("You Don't have any Address to view please add address first", HttpStatus.OK, "null");

            }
            else
                return ResponseHandler.generateResponse("Your Address are As follows !!!", HttpStatus.OK, addresses);



        }

    }


    public ResponseEntity<Object> deleteAddress(Long id)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();

            Boolean bool = addressRepo.findById(id).isPresent();

            if (bool == true) {
                Address address = addressRepo.findById(id).get();

                if (address.getUser().getId() == user.getId()) {

                    addressRepo.deleteByid(id);

                    return ResponseHandler.generateResponse3("Address deleted Successfully !", HttpStatus.OK, "null");
                }

                return ResponseHandler.generateResponse3("You entered incorrect Address ID", HttpStatus.BAD_REQUEST, "null");

            }

            return ResponseHandler.generateResponse3("You entered wrong Address ID", HttpStatus.BAD_REQUEST, "null");

        }


    }

}
