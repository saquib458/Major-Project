package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
