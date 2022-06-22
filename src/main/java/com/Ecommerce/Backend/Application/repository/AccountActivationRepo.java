package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.AccountActivation;
import org.springframework.data.repository.CrudRepository;

public interface AccountActivationRepo extends CrudRepository<AccountActivation,Long> {


    AccountActivation findByEmail(String username);

}
