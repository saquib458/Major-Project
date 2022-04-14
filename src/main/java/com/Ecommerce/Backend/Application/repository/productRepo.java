package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.product;
import org.springframework.data.repository.CrudRepository;

public interface productRepo extends CrudRepository<product,Long> {
}
