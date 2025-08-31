package com.microservices.ecomerce.customer.adapter.outbound;

import com.microservices.ecomerce.customer.domain.ports.outbound.CustomerRepository;
import com.microservices.ecomerce.customer.infrastructure.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import com.microservices.ecomerce.customer.infrastructure.mappers.CustomerMapper;
import com.microservices.ecomerce.customer.infrastructure.persistence.MongoCustomerRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final MongoCustomerRepository mongoCustomerRepository;
    private final CustomerMapper customerMapper;

    public CustomerRepositoryAdapter(MongoCustomerRepository mongoCustomerRepository, CustomerMapper customerMapper) {
        this.mongoCustomerRepository = mongoCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        var entity = customerMapper.toEntity(customerDto);
        var saved = mongoCustomerRepository.save(entity);
        return customerMapper.toDto(saved);
    }

    @Override
    public Optional<CustomerDto> findById(String id) {
        return mongoCustomerRepository.findById(id)
                .map(customerMapper::toDto);
    }

    @Override
    public List<CustomerDto> findAll() {
        return mongoCustomerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        if (!mongoCustomerRepository.existsById(id)) {
            throw new NotFoundException("Customer not found with id: " + id);
        }
        mongoCustomerRepository.deleteById(id);
    }
}
