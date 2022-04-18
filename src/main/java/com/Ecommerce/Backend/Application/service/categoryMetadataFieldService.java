package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.entities.categoryMetadataField;
import com.Ecommerce.Backend.Application.repository.categoryMetadataFieldRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class categoryMetadataFieldService {

    @Autowired
    categoryMetadataFieldRepo categoryMetadataFieldRepo;

    public ResponseEntity<Object> addCategoryMetadata(String field)
    {
        categoryMetadataField categoryMetadataField=new categoryMetadataField();

        if(Objects.isNull(categoryMetadataFieldRepo.findByName(field)))
        {
            categoryMetadataField.setName(field);
            categoryMetadataFieldRepo.save(categoryMetadataField);

            return ResponseHandler.generateResponse3("category Metadata field added successfully !!!", HttpStatus.OK, "null");

        }
        return ResponseHandler.generateResponse3("You entered duplicate Metadata field name", HttpStatus.OK, "null");

    }

    public ResponseEntity<Object> viewAllCategoryMetadata()
    {
        List<categoryMetadataField> categoryMetadataFieldList=new ArrayList<>();

        categoryMetadataFieldList= (List<categoryMetadataField>) categoryMetadataFieldRepo.findAll();

        if(categoryMetadataFieldList.isEmpty())
        {
            return ResponseHandler.generateResponse3("There is no Category Metadata Field added yet please add first to view !!! ", HttpStatus.OK, "null");

        }

        return ResponseHandler.generateResponse("Category Metadata Field List", HttpStatus.OK, categoryMetadataFieldList);

    }

}
