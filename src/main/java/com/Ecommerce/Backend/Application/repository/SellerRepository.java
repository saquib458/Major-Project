package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends CrudRepository<Seller,Long> {
    Seller findByGst(String gst);

    @Query(value = "select company_name from seller where company_name = :name ",nativeQuery = true)
    Object findBycompany_name(@Param("name") String name);
}
