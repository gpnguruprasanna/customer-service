package com.guru.microservice.customer_service.requestDto;

import lombok.Data;

import java.util.Date;
@Data
public class CustomerRequestDto {
    private int custId;
    private String custName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;
}
