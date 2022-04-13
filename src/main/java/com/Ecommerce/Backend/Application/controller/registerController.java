package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.userDto;
import com.Ecommerce.Backend.Application.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {

    @Autowired
    userService userService;


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody userDto dto)
    {

      return  userService.registerUser(dto);

    }
}
