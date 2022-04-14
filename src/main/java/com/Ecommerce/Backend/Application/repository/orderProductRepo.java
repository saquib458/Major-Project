package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.orderProduct;
import org.springframework.data.repository.CrudRepository;

public interface orderProductRepo extends CrudRepository<orderProduct,Long> {
}
