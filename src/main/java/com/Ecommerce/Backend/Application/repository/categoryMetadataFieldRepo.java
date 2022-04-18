package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.categoryMetadataField;
import org.springframework.data.repository.CrudRepository;

public interface categoryMetadataFieldRepo extends CrudRepository<categoryMetadataField,Long> {
    categoryMetadataField findByName(String field);

}
