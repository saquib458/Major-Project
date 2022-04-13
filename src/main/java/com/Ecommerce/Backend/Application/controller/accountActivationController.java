package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.accountActivationDto;
import com.Ecommerce.Backend.Application.service.accountActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class accountActivationController {

    @Autowired
    accountActivationService accountActivationService;

    @PostMapping("/activation/request/{username}")
    public ResponseEntity<Object> accountActivationRequest(@PathVariable String username)
    {
        return  accountActivationService.accountActivationRequest(username);
    }

    @PutMapping("/activate/account")
    public ResponseEntity<Object> activateAccount(@RequestBody accountActivationDto dto)
    {
        return accountActivationService.activateAccount(dto);
    }
}
