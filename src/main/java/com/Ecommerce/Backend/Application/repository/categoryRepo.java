package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface categoryRepo extends CrudRepository<category, Long> {


    @Query(value = "select category_name from category where parent_category_id =:id",nativeQuery = true)
    List<String> findCategoryAssociatedWithId(@Param("id") long id);

    category findById(long id);
    @Query(value = "select * from category where category_name =:categoryName",nativeQuery = true)
    category findByCategoryName(@Param("categoryName") String categoryName);

    List<category> findAll();
}
