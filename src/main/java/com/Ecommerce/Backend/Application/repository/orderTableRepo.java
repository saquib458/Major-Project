package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.orderTable;
import org.springframework.data.repository.CrudRepository;

public interface orderTableRepo extends CrudRepository<orderTable,Long> {
}
