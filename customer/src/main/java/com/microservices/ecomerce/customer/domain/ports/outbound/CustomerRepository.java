package com.microservices.ecomerce.customer.domain.ports.outbound;

import java.util.List;

import com.microservices.ecomerce.customer.application.dto.CustomerDto;

public interface CustomerRepository {
    CustomerDto save(CustomerDto customer);
    CustomerDto findById(String id);
    List<CustomerDto> findAll();
    void deleteById(String id);
}
