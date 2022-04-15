package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

     @Query(value = "SELECT * FROM customer order by user_id asc LIMIT 10 OFFSET 0",nativeQuery = true)
    List<Customer> findAll();

}
