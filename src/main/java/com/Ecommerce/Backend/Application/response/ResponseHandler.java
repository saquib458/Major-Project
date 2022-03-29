package com.Ecommerce.Backend.Application.response;

import com.Ecommerce.Backend.Application.entities.Customer;
import com.Ecommerce.Backend.Application.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data",responseObj.toString());
        map.put("date",new Date());


        System.out.println(map);

        return new ResponseEntity<Object>(map,status);
    }



}




