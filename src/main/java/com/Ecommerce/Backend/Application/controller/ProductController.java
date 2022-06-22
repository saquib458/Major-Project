package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/view/product/{id}")
    public ResponseEntity<Object> viewProduct(@PathVariable long id)
    {
        return productService.viewProduct(id);
    }

    @GetMapping("/view/allproduct")
    public ResponseEntity<Object> viewAllProduct()
    {
        return productService.viewAllProduct();
    }

    @PatchMapping("/activate/product/{productId}")
    public ResponseEntity<Object> activateProduct(@PathVariable long productId)
    {
       return productService.activateProduct(productId);
    }

    @PatchMapping("/deActivate/product/{productId}")
    public ResponseEntity<Object> deActivateProduct(@PathVariable long productId)
    {
        return productService.deActivateProduct(productId);
    }

}
