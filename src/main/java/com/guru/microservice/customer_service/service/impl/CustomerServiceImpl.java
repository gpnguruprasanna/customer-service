package com.guru.microservice.customer_service.service.impl;

import com.guru.microservice.customer_service.entity.Customer;
import com.guru.microservice.customer_service.exceptions.CustomerNotFoundException;
import com.guru.microservice.customer_service.repository.CustomerRepository;
import com.guru.microservice.customer_service.requestDto.CustomerRequestDto;
import com.guru.microservice.customer_service.responseDto.CustomerReponseDto;
import com.guru.microservice.customer_service.service.CustomerService;
import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerReponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        System.out.println(customerRequestDto);
        System.out.println(customer);
        Customer customer1 =   customerRepository.save(customer);
        CustomerReponseDto customerReponseDto = modelMapper.map(customer1, CustomerReponseDto.class);
        return customerReponseDto;
    }

    @Override
    public CustomerReponseDto getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not found exception :" + id));
        CustomerReponseDto customerReponseDto = modelMapper.map(customer, CustomerReponseDto.class);
        return customerReponseDto;
    }

    @Override
    public Page<CustomerReponseDto> getAllCustomer(Predicate predicate, Pageable pageRequest) {
        Page<Customer> customerPage = customerRepository.findAll(predicate,pageRequest);
        Function<Customer, CustomerReponseDto> reponseDtoFunction = (customer) -> modelMapper.map(customer, CustomerReponseDto.class);
        List<CustomerReponseDto> customerList=  customerPage.stream().map(reponseDtoFunction).collect(Collectors.toList());
        return new PageImpl<>(customerList,pageRequest,customerPage.getTotalElements());
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not found exception :" + id));
        boolean isDeleted = true;
        try {
            if (customer != null) {
                customerRepository.delete(customer);
            }
        } catch (Exception e) {
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public CustomerReponseDto updateCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepository.findById(customerRequestDto.getCustId()).orElseThrow(() -> new CustomerNotFoundException("Customer Not found exception :" + customerRequestDto.getCustId()));
        Customer updateCustomer = modelMapper.map(customerRequestDto, Customer.class);
        customer = customerRepository.save(updateCustomer);
        return modelMapper.map(customer, CustomerReponseDto.class);
    }
}
