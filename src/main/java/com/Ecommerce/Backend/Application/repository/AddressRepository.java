package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
