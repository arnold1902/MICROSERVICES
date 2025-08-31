package com.microservices.ecomerce.customer.domain.ports.outbound;

import java.util.List;
import java.util.Optional;

import com.microservices.ecomerce.customer.application.dto.CustomerDto;

public interface CustomerRepository {
    CustomerDto save(CustomerDto customer);
    Optional<CustomerDto> findById(String id);
    List<CustomerDto> findAll();
    void deleteById(String id);
}
