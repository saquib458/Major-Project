package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.ForgotPassword;
import org.springframework.data.repository.CrudRepository;

public interface ForgotPasswordRepo extends CrudRepository<ForgotPassword,Long> {

    ForgotPassword findByEmail(String username);
}
