package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.entities.product;
import com.Ecommerce.Backend.Application.repository.productRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    @Autowired
    productRepo productRepo;

    public ResponseEntity<Object> viewProduct(long productId)
    {
        if(productRepo.findById(productId)==null)
            return  ResponseHandler.generateResponse3("No product found for a given id !!!! ", HttpStatus.OK, "null");

        product product=productRepo.findById(productId);

        return  ResponseHandler.generateResponse("Product Details !!!! ", HttpStatus.OK, product);

    }

    public ResponseEntity<Object> viewAllProduct()
    {
        if(productRepo.findAll().isEmpty())
            return  ResponseHandler.generateResponse3("No product found to display !!!! ", HttpStatus.OK, "null");

        List<product> productList= productRepo.findAll();

        return  ResponseHandler.generateResponse("Product Details !!!! ", HttpStatus.OK, productList);

    }

    public ResponseEntity<Object> activateProduct(long productId)
    {
        if(productRepo.findById(productId)==null)
            return  ResponseHandler.generateResponse3("No product found for a given id !!!! ", HttpStatus.OK, "null");


        product product=productRepo.findById(productId);

        if(product.getIs_active())
            return  ResponseHandler.generateResponse3("Product is already Activated !!!! ", HttpStatus.OK, "null");

        product.setIs_active(Boolean.TRUE);

        productRepo.save(product);

        return  ResponseHandler.generateResponse3("Product Activated successfully !!!! ", HttpStatus.OK, "null");


    }


    public ResponseEntity<Object> deActivateProduct(long productId)
    {
        if(productRepo.findById(productId)==null)
            return  ResponseHandler.generateResponse3("No product found for a given id !!!! ", HttpStatus.OK, "null");


        product product=productRepo.findById(productId);

        if(!(product.getIs_active()))
             return  ResponseHandler.generateResponse3("Product is already deActivated !!!! ", HttpStatus.OK, "null");


        product.setIs_active(Boolean.FALSE);

        productRepo.save(product);

        return  ResponseHandler.generateResponse3("Product deActivated successfully !!!! ", HttpStatus.OK, "null");


    }

}
