package com.guru.microservice.customer_service.service;

import com.guru.microservice.customer_service.requestDto.CustomerRequestDto;
import com.guru.microservice.customer_service.responseDto.CustomerReponseDto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    public CustomerReponseDto createCustomer(CustomerRequestDto customerRequestDto);
    public CustomerReponseDto getCustomer(Long id);
    public Page<CustomerReponseDto> getAllCustomer(Predicate predicate, Pageable pageRequest);
    public boolean deleteCustomer(Long id);
    public CustomerReponseDto updateCustomer(CustomerRequestDto customerRequestDto);
}
