package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.entities.CategoryMetadataField;
import com.Ecommerce.Backend.Application.repository.CategoryMetadataFieldRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryMetadataFieldService {

    @Autowired
    CategoryMetadataFieldRepo categoryMetadataFieldRepo;

    public ResponseEntity<Object> addCategoryMetadata(String field)
    {
        CategoryMetadataField categoryMetadataField=new CategoryMetadataField();

        if(Objects.isNull(categoryMetadataFieldRepo.findByName(field)))
        {
            categoryMetadataField.setName(field);
            categoryMetadataFieldRepo.save(categoryMetadataField);

            return ResponseHandler.generateResponse3("category Metadata field added successfully !!!", HttpStatus.OK, "null");

        }
        return ResponseHandler.generateResponse3("You entered duplicate Metadata field name", HttpStatus.BAD_REQUEST, "null");

    }

    public ResponseEntity<Object> viewAllCategoryMetadata()
    {
        List<CategoryMetadataField> categoryMetadataFieldList=new ArrayList<>();

        categoryMetadataFieldList= (List<CategoryMetadataField>) categoryMetadataFieldRepo.findAll();

        if(categoryMetadataFieldList.isEmpty())
        {
            return ResponseHandler.generateResponse3("There is no Category Metadata Field added yet please add first to view !!! ", HttpStatus.NO_CONTENT, "null");

        }

        return ResponseHandler.generateResponse("Category Metadata Field List", HttpStatus.OK, categoryMetadataFieldList);

    }

}
