package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.accountActivation;
import org.springframework.data.repository.CrudRepository;

public interface accountActivationRepo extends CrudRepository<accountActivation,Long> {


    accountActivation findByEmail(String username);

}
