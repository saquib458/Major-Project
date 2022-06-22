package com.Ecommerce.Backend.Application.controller;


import com.Ecommerce.Backend.Application.dtoClasses.UserDto;
import com.Ecommerce.Backend.Application.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class SellerController {

   @Autowired
   SellerService sellerService;

  @PatchMapping("/update/address/{id}")
  @Transactional
  @Rollback(false)
  public ResponseEntity<Object> updateAddress(@PathVariable Long id, @RequestBody UserDto dto)
  {
      return  sellerService.updateAddress(id,dto);
  }

}
