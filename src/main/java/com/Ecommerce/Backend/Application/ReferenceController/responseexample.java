//package com.Ecommerce.Backend.Application.controller;
//
//import com.Ecommerce.Backend.Application.entities.Address2;
//import com.Ecommerce.Backend.Application.repository.Address2Repository;
//import com.Ecommerce.Backend.Application.response.ResponseHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class responseexample {
//
//
//    @Autowired
//    Address2Repository repository;
//
//    @GetMapping("/demo")
//    public ResponseEntity<Object> demo()
//    {
//        try {
//            Address2 add = new Address2(1L,"kanpur","up","India","171 -sujat ganj","208013"," ");
//            Object save = repository.save(add);
//
//            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, save);
//        } catch (Exception e) {
//            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
//        }
//
//
//    }
//
//}
