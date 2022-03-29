package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
