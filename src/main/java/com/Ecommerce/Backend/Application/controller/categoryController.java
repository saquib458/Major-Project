package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.categoryDto;
import com.Ecommerce.Backend.Application.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class categoryController {

    @Autowired
    categoryService categoryService;

    @PostMapping("/add/category")
    public ResponseEntity<Object> addCategory(@RequestBody categoryDto dto)
    {
        return categoryService.addCategory(dto);
    }

    @GetMapping("/view/category/{id}")
    public ResponseEntity<Object> viewCategory(@PathVariable long id)
    {
        return categoryService.viewCategory(id);
    }

    @GetMapping("/view/allcategory")
    public ResponseEntity<Object> findAllCategory()
    {
        return categoryService.viewAllCategory();
    }

    @PostMapping("/add/categorymetadatafieldvalues")
    public ResponseEntity<Object> addCategoryMetadataFieldValues(@RequestBody categoryDto dto)
    {
        return categoryService.addCategoryMetadataFieldValues(dto);
    }

    @PatchMapping("/update/categorymetadatafieldvalues")
    public ResponseEntity<Object> updateCategoryMetadataFieldValues(@RequestBody categoryDto dto)
    {
        return categoryService.updateCategoryMetadataFieldValues(dto);
    }
}
