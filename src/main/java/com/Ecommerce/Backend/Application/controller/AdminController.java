package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

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

   @GetMapping("/list/customers")
    public ResponseEntity<Object> listCustomers()
   {
       return  adminService.listOfCustomers();
   }

    @GetMapping("/list/sellers")
    public ResponseEntity<Object> listSellers()
    {
        return  adminService.listOfSellers();
    }

}
