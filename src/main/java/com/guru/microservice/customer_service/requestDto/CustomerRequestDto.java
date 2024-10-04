package com.guru.microservice.customer_service.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class CustomerRequestDto {
    private Long custId;
    private String custName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;
}
