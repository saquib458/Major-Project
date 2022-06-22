package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Long> {

    Product findById(long id);

    List<Product> findAll();

}
