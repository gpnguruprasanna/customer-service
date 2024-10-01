package com.guru.microservice.customer_service.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerServiceConfiguration {

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
