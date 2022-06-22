package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.OrderTable;
import org.springframework.data.repository.CrudRepository;

public interface OrderTableRepo extends CrudRepository<OrderTable,Long> {
}
