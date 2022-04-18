package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface productRepo extends CrudRepository<product,Long> {

    product findById(long id);

    List<product> findAll();

}
