package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.category;
import org.springframework.data.repository.CrudRepository;

public interface categoryRepo extends CrudRepository<category, Long> {
}
