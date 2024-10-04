package com.guru.microservice.customer_service.responseDto;

import lombok.Data;

import java.util.Date;
@Data
public class CustomerReponseDto {
    private int custId;
    private String custName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;
}
