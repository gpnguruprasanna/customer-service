package com.guru.microservice.customer_service.repository;

import com.guru.microservice.customer_service.entity.Customer;
import com.guru.microservice.customer_service.entity.QCustomer;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, QuerydslPredicateExecutor<Customer>
        , QuerydslBinderCustomizer<QCustomer> {
    default void customize(QuerydslBindings bindings, QCustomer root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.custId);
        bindings.including(root.email);
        bindings.including(root.custName);
        bindings.bind(String.class).first((StringPath path, String value) ->
                path.containsIgnoreCase(value));
    }
}
