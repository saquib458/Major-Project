package com.Ecommerce.Backend.Application.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data",responseObj);
        map.put("date",new Date());


        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> generateResponse2(String message, HttpStatus status, List<String> list) {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("List of validations fails ",list);
        map.put("date",new Date());


        return new ResponseEntity<Object>(map, HttpStatus.valueOf(HttpStatus.OK.value()));
    }

    public static ResponseEntity<Object> generateResponse3(String message, HttpStatus status,String str) {


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        if(str!="null")
        map.put("You Logged in as ",str);
        map.put("date",new Date());


        return new ResponseEntity<Object>(map, status);
    }


}




