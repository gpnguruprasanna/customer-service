package com.guru.microservice.customer_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Customer {
    @Id
    @Column(name="cust_id")
    private Long custId;

    @Column(name="cust_name")
    private String custName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;
}
