package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.forgotPassword;
import org.springframework.data.repository.CrudRepository;

public interface forgotPasswordRepo extends CrudRepository<forgotPassword,Long> {

    forgotPassword findByEmail(String username);
}
