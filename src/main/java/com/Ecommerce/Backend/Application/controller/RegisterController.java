package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.UserDto;
import com.Ecommerce.Backend.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserDto dto)
    {

      return  userService.registerUser(dto);

    }
}
