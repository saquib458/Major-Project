package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller,Long> {
}
