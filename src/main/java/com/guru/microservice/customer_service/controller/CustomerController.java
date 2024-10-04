package com.guru.microservice.customer_service.controller;

import com.guru.microservice.customer_service.requestDto.CustomerRequestDto;
import com.guru.microservice.customer_service.responseDto.CustomerReponseDto;
import com.guru.microservice.customer_service.responseDto.ResponseDto;
import com.guru.microservice.customer_service.responseDto.ResponseError;
import com.guru.microservice.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        CustomerReponseDto customerReponseDto = customerService.createCustomer(customerRequestDto);
        ResponseDto responseDto = new ResponseDto(HttpStatus.CREATED.value(), Boolean.TRUE, customerReponseDto, null);
        return ResponseEntity.of(Optional.of(responseDto));
    }

    @GetMapping("/get-customer/{id}")
    public ResponseEntity<ResponseDto> getCustomer(@PathVariable long id) {
        CustomerReponseDto customerReponseDto = customerService.getCustomer(id);
        ResponseDto responseDto = new ResponseDto(HttpStatus.OK.value(), Boolean.TRUE, customerReponseDto, null);
        return ResponseEntity.of(Optional.of(responseDto));
    }

    @GetMapping("/delete-customer/{id}")
    public ResponseEntity<ResponseDto> deleteCustomer(@PathVariable long id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        ResponseDto responseDto = new ResponseDto(HttpStatus.NO_CONTENT.value(), Boolean.TRUE,null,
                isDeleted?null:new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.toString(),List.of("Customer not deleted :"+id)));
        return ResponseEntity.of(Optional.of(responseDto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> getAllCustomers() {
        List<CustomerReponseDto> customerReponseDtoList = customerService.getAllCustomer();
        ResponseDto responseDto = new ResponseDto(HttpStatus.OK.value(), Boolean.TRUE, customerReponseDtoList, null);
        return ResponseEntity.of(Optional.of(responseDto));
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        CustomerReponseDto customerReponseDto = customerService.updateCustomer(customerRequestDto);
        ResponseDto responseDto = new ResponseDto(HttpStatus.OK.value(), Boolean.TRUE, customerReponseDto, null);
        return ResponseEntity.of(Optional.of(responseDto));
    }
}
