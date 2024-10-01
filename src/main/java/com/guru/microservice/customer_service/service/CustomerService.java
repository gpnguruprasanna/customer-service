package com.guru.microservice.customer_service.service;

import com.guru.microservice.customer_service.requestDto.CustomerRequestDto;
import com.guru.microservice.customer_service.responseDto.CustomerReponseDto;

import java.util.List;

public interface CustomerService {
    public CustomerReponseDto createCustomer(CustomerRequestDto customerRequestDto);
    public CustomerReponseDto getCustomer(Long id);
    public List<CustomerReponseDto> getAllCustomer();
    public CustomerReponseDto deleteCustomer(Long id);
    public CustomerReponseDto updateCustomer(CustomerRequestDto customerRequestDto);
}
