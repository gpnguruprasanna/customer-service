package com.guru.microservice.customer_service.responseDto;

import lombok.Data;

@Data
public class ResponseDto {
    private String error;
    private Object object;

}
