package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.userDto;
import com.Ecommerce.Backend.Application.entities.User;
import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import com.Ecommerce.Backend.Application.service.userService;
import com.Ecommerce.Backend.Application.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class UserController {
    @Autowired
    Validation validation;

    @Autowired
    userService userService;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/current/user")
    public User currentUser()
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null || !authentication.isAuthenticated())
            return null;
        else {
            User user = (User) authentication.getPrincipal();
            return user;
           // return ResponseHandler.generateResponse("Details of User", HttpStatus.OK, user);
        }

    }

    @GetMapping("/profile")
    public ResponseEntity<Object> userDetails()
    {
       return userService.userDetails();

    }


    @PatchMapping("/update/profile")
    @Transactional
    @Rollback(false)
    public ResponseEntity<Object> updateProfile(@RequestBody userDto dto)
    {
       return  userService.updateProfile(dto);

    }

    @PatchMapping("/update/password")
    @Transactional
    @Rollback(false)
    public ResponseEntity<Object> updatePassword(@RequestBody userDto dto)
    {
        return userService.updatePassword(dto);
    }


    @GetMapping("/view/product/{id}")
    public ResponseEntity<Object> viewProduct(@PathVariable long id)
    {
        return userService.viewProduct(id);
    }

    @GetMapping("/view/allproduct")
    public ResponseEntity<Object> viewAllProduct()
    {
        return userService.viewAllProduct();
    }


}
