package com.Ecommerce.Backend.Application.service;


import com.Ecommerce.Backend.Application.dtoClasses.categoryDto;
import com.Ecommerce.Backend.Application.entities.category;
import com.Ecommerce.Backend.Application.entities.categoryMetadataField;
import com.Ecommerce.Backend.Application.entities.categoryMetadataFieldValues;
import com.Ecommerce.Backend.Application.repository.categoryMetadataFieldRepo;
import com.Ecommerce.Backend.Application.repository.categoryMetadataFieldValuesRepo;
import com.Ecommerce.Backend.Application.repository.categoryRepo;
import com.Ecommerce.Backend.Application.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryService {
    @Autowired
    categoryRepo categoryRepo;

    @Autowired
    categoryMetadataFieldRepo categoryMetadataFieldRepo;

    @Autowired
    categoryMetadataFieldValuesRepo categoryMetadataFieldValuesRepo;

    public ResponseEntity<Object> addCategory(categoryDto dto) {
        if(dto.getParentId()==0)
        {   if( categoryRepo.findByCategoryName(dto.getCategoryName())!=null)
                return ResponseHandler.generateResponse3("category is already present!!!! ", HttpStatus.OK, "null");

            category category = new category();
            category.setCategoryName(dto.getCategoryName());
            categoryRepo.save(category);
            return ResponseHandler.generateResponse3("category saved successfully !!!! ", HttpStatus.OK, "null");
        }


        if (categoryRepo.findById(dto.getParentId())!=null) {
            List<String> categoryNameList = categoryRepo.findCategoryAssociatedWithId(dto.getParentId());
             category parentCategory=categoryRepo.findById(dto.getParentId());

            if (categoryNameList.isEmpty()) {
                if(parentCategory.getCategoryName().equals(dto.getCategoryName()))
                    return ResponseHandler.generateResponse3("category name is duplicate  in root level  !!!! ", HttpStatus.OK, "null");

                while (parentCategory.getCategory()!=null)
                {
                    if(parentCategory.getCategoryName().equals(dto.getCategoryName()))
                        return ResponseHandler.generateResponse3("category name is duplicate  in root level !!!! ", HttpStatus.OK, "null");
                    parentCategory=parentCategory.getCategory();
                }

                if(parentCategory.getCategoryName().equals(dto.getCategoryName()))
                    return ResponseHandler.generateResponse3("category name is duplicate  in root level !!!! ", HttpStatus.OK, "null");


                category category = new category();
                category.setCategoryName(dto.getCategoryName());
                category.setCategory(categoryRepo.findById(dto.getParentId()));

                categoryRepo.save(category);
                return ResponseHandler.generateResponse3("category saved successfully !!!! ", HttpStatus.OK, "null");


            }
            else {
                for (String str:categoryNameList
                     ) {
                    if(str.equals(dto.getCategoryName()))
                        return ResponseHandler.generateResponse3("category name is duplicate  in breadth level !!!! ", HttpStatus.OK, "null");

                }

                while (parentCategory.getCategory()!=null)
                {
                    if(parentCategory.getCategoryName().equals(dto.getCategoryName()))
                        return ResponseHandler.generateResponse3("category name is duplicate  in root level !!!! ", HttpStatus.OK, "null");
                  parentCategory=parentCategory.getCategory();
                }

                if(parentCategory.getCategoryName().equals(dto.getCategoryName()))
                    return ResponseHandler.generateResponse3("category name is duplicate  in root level !!!! ", HttpStatus.OK, "null");

                category category = new category();
                category.setCategoryName(dto.getCategoryName());
                category.setCategory(categoryRepo.findById(dto.getParentId()));

                categoryRepo.save(category);
                return ResponseHandler.generateResponse3("category saved successfully !!!! ", HttpStatus.OK, "null");


            }

        }
        return ResponseHandler.generateResponse3("category not found by given parent id !!!! ", HttpStatus.OK, "null");

    }

    public ResponseEntity<Object> viewCategory(long id)
    {
        if(categoryRepo.findById(id)==null)
            return ResponseHandler.generateResponse3("category not found by given id !!!! ", HttpStatus.OK, "null");

        category category=categoryRepo.findById(id);

        return ResponseHandler.generateResponse("category details!!!! ", HttpStatus.OK, category);

    }


    public ResponseEntity<Object> viewAllCategory()
    {
        if(categoryRepo.findAll().isEmpty())
            return ResponseHandler.generateResponse3("no category added yet!!!! ", HttpStatus.OK, "null");


        return ResponseHandler.generateResponse("category List details !!!! ", HttpStatus.OK, categoryRepo.findAll());

    }


    public ResponseEntity<Object> addCategoryMetadataFieldValues(categoryDto dto) {
        if(categoryMetadataFieldValuesRepo.findForUpdate(dto.getCategoryId(), dto.getMetaDataFieldId())!=null)
            return  ResponseHandler.generateResponse3("you entered duplicate metadata field values please update the previous one !!! ", HttpStatus.OK, "null");

        if (categoryRepo.findById(dto.getCategoryId()) != null) {

            if (!(categoryMetadataFieldRepo.findById(dto.getMetaDataFieldId()).isPresent()))
                return ResponseHandler.generateResponse3("category Metadata Field  not found by given id !!!! ", HttpStatus.OK, "null");

            categoryMetadataFieldValues categoryMetadataFieldValues = new categoryMetadataFieldValues();

            categoryMetadataFieldValues.setCategory(categoryRepo.findById(dto.getCategoryId()));
            categoryMetadataFieldValues.setCategoryMetadataField(categoryMetadataFieldRepo.findById(dto.getMetaDataFieldId()).get());
            categoryMetadataFieldValues.setValue(dto.getValues());

            categoryMetadataFieldValuesRepo.save(categoryMetadataFieldValues);

            return ResponseHandler.generateResponse3("category Metadata Field values Added successfully !!!! ", HttpStatus.OK, "null");


        }
        return ResponseHandler.generateResponse3("category not found by given id !!!! ", HttpStatus.OK, "null");


    }

    public ResponseEntity<Object> updateCategoryMetadataFieldValues(categoryDto dto) {

        if(categoryMetadataFieldValuesRepo.findForUpdate(dto.getCategoryId(), dto.getMetaDataFieldId())==null)
        return  ResponseHandler.generateResponse3("no Metadata Field Value exist to update!!!! ", HttpStatus.OK, "null");

        categoryMetadataFieldValues categoryMetadataFieldValues=categoryMetadataFieldValuesRepo.findForUpdate(dto.getCategoryId(), dto.getMetaDataFieldId());
        categoryMetadataFieldValues.setValue(categoryMetadataFieldValues.getValue()+","+dto.getValues());

        categoryMetadataFieldValuesRepo.save(categoryMetadataFieldValues);

        return  ResponseHandler.generateResponse3("Metadata Field Values update successfully !!!! ", HttpStatus.OK, "null");


    }



    }
