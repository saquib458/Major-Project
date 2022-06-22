package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.CategoryMetadataField;
import org.springframework.data.repository.CrudRepository;

public interface CategoryMetadataFieldRepo extends CrudRepository<CategoryMetadataField,Long> {
    CategoryMetadataField findByName(String field);

}
