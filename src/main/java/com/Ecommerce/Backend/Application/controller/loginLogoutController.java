package com.Ecommerce.Backend.Application.controller;

import com.Ecommerce.Backend.Application.repository.UserRepository;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import com.Ecommerce.Backend.Application.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class loginLogoutController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    userService userService;



//    @PostMapping("/custom/login")
//    public ResponseEntity<Object> loginMessage() {
//        return userService.login();
//    }

    @GetMapping("/logout/successfully")
    public ResponseEntity<Object> logoutMessage()
    {

        return ResponseHandler.generateResponse3("Logout Successfully !!!! ", HttpStatus.OK, "null");


    }
}
