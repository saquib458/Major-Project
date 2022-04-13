package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.forgotPasswordDto;
import com.Ecommerce.Backend.Application.service.forgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class forgotPasswordController {

    @Autowired
    forgotPasswordService forgotPasswordService;

    @PostMapping("/forgot/password/{username}")
   public ResponseEntity<Object> forgotPassword(@PathVariable String username)
    {
        return forgotPasswordService.forgotPasswordM(username);
    }


    @PostMapping("/reset/password")
   public ResponseEntity<Object> resetPassword(@RequestBody forgotPasswordDto dto )
    {
        return forgotPasswordService.resetPassword(dto);
    }
}
