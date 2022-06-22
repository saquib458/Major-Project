package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.CategoryMetadataFieldValues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryMetadataFieldValuesRepo extends CrudRepository<CategoryMetadataFieldValues,Long> {


    @Query(value = "select * from category_metadata_field_values where category_id=:categoryId AND category_metadata_id=:categoryMetadataId",nativeQuery = true)
    CategoryMetadataFieldValues findForUpdate(@Param("categoryId") long categoryId, @Param("categoryMetadataId")long categoryMetadataId);
}
