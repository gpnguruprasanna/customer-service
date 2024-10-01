package com.guru.microservice.customer_service.exceptions;

import lombok.ToString;

import java.util.function.Supplier;

@ToString
public class CustomerNotFoundException extends RuntimeException  {
    private String message;

    public CustomerNotFoundException(String message) {
        super();
        this.message=message;
    }

}
