package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.OrderStatus;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusRepo extends CrudRepository<OrderStatus,Long> {
}
