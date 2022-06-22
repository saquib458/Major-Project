package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.OrderProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepo extends CrudRepository<OrderProduct,Long> {
}
