package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.addressDto;
import com.Ecommerce.Backend.Application.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@RestController
public class customerController {


    @Autowired
    customerService customerService;

    @PostMapping("/add/address")
    public ResponseEntity<Object> addNewAddress(@RequestBody addressDto dto)
    {
        return customerService.addNewAddress(dto);
    }

    @GetMapping("/view/addresses")
    public ResponseEntity<Object> viewAddresses()
    {
        return customerService.viewAddresses();
    }



    @DeleteMapping("/delete/address/{id}")
    @Transactional
    @Rollback(false)
    public ResponseEntity<Object> deleteAddress(@PathVariable Long id)
    {
        return customerService.deleteAddress(id);
    }
}
