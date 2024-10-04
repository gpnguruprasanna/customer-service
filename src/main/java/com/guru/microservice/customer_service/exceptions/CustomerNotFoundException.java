package com.guru.microservice.customer_service.exceptions;

import lombok.ToString;

@ToString
public class CustomerNotFoundException extends RuntimeException {
    private String message;

    public CustomerNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
