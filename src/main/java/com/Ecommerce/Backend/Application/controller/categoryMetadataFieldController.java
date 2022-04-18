package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.service.categoryMetadataFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class categoryMetadataFieldController {

    @Autowired
    categoryMetadataFieldService categoryMetadataFieldService;

    @PostMapping("/add/categoryMetadataField/{field}")
    public ResponseEntity<Object> addCategoryMetadata(@PathVariable String field)
    {
        return categoryMetadataFieldService.addCategoryMetadata(field);
    }

    @GetMapping("/viewAll/categoryMetadata")
    public ResponseEntity<Object> viewAllCategoryMetadata()
    {
        return categoryMetadataFieldService.viewAllCategoryMetadata();
    }


}
