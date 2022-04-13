package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    adminService adminService;

    @PatchMapping("/activate/{username}")
    public ResponseEntity<Object> activateUser(@PathVariable String username)
    {
        return adminService.activateUser(username);
    }

    @PatchMapping("/deactivate/{username}")
    public ResponseEntity<Object> deActivateUser(@PathVariable String username)
    {
        return adminService.deActivateUser(username);
    }




}
