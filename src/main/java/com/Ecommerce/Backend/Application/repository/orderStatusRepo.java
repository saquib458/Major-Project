package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.orderStatus;
import org.springframework.data.repository.CrudRepository;

public interface orderStatusRepo extends CrudRepository<orderStatus,Long> {
}
