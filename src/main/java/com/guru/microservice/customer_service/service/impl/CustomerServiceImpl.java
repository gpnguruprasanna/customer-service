package com.guru.microservice.customer_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guru.microservice.customer_service.entity.Customer;
import com.guru.microservice.customer_service.exceptions.CustomerNotFoundException;
import com.guru.microservice.customer_service.repository.CustomerRepository;
import com.guru.microservice.customer_service.requestDto.CustomerRequestDto;
import com.guru.microservice.customer_service.responseDto.CustomerReponseDto;
import com.guru.microservice.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public CustomerReponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public CustomerReponseDto getCustomer(Long id) {
      Customer customer=  customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer Not found exception :"+id));
        return null;
    }

    @Override
    public List<CustomerReponseDto> getAllCustomer() {
        return null;
    }

    @Override
    public CustomerReponseDto deleteCustomer(Long id) {
        return null;
    }

    @Override
    public CustomerReponseDto updateCustomer(CustomerRequestDto customerRequestDto) {
        return null;
    }
}
