package com.guru.microservice.customer_service.controller;

import com.guru.microservice.customer_service.requestDto.CustomerRequestDto;
import com.guru.microservice.customer_service.responseDto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    @PostMapping("create")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto){

      //  ResponseDto responseDto=new ResponseDto("success",new Object());
        //return ResponseEntity.of( HttpStatus.CREATED);
        return null;
    }
}
