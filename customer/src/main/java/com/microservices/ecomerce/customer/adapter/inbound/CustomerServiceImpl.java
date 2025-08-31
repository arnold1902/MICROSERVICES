package com.microservices.ecomerce.customer.adapter.inbound;

import com.microservices.ecomerce.customer.domain.ports.inbound.CustomerService;
import com.microservices.ecomerce.customer.domain.ports.outbound.CustomerRepository;
import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import com.microservices.ecomerce.customer.infrastructure.exceptions.NotFoundException;
import com.microservices.ecomerce.customer.infrastructure.utils.DtoMergeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CustomerDto findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto update(String id, CustomerDto customerDto) {
        CustomerDto existing = customerRepository.findById(id);
        if (existing == null) {
            throw new NotFoundException("Customer not found with id: " + id);
        }
        CustomerDto merged = DtoMergeUtil.mergeCustomer(existing, customerDto);
        return customerRepository.save(merged);
    }

    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
