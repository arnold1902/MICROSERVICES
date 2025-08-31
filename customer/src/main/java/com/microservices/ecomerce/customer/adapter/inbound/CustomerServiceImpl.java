package com.microservices.ecomerce.customer.adapter.inbound;

import com.microservices.ecomerce.customer.domain.ports.inbound.CustomerService;
import com.microservices.ecomerce.customer.domain.ports.outbound.CustomerRepository;
import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import com.microservices.ecomerce.customer.infrastructure.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerRepository.save(customerDto);
    }

    @Override
    public Optional<CustomerDto> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto update(String id, CustomerDto customerDto) {
        Optional<CustomerDto> existing = customerRepository.findById(id);
        if (existing.isEmpty()) {
            throw new NotFoundException("Customer not found with id: " + id);
        }
        CustomerDto updated = customerDto;
        return customerRepository.save(updated);
    }

    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
