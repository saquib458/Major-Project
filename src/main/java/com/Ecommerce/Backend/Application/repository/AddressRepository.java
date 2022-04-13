package com.Ecommerce.Backend.Application.repository;

import com.Ecommerce.Backend.Application.entities.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.Set;

public interface AddressRepository extends CrudRepository<Address,Long> {

    @Modifying
    @Query(value = "delete from address where id = :id ",nativeQuery = true)
    void deleteByid(@Param("id") Long id);

    @Query(value="select * from address where user_id=:id",nativeQuery = true)
    Set<Address> findByUserId(@Param("id") long id);
}
