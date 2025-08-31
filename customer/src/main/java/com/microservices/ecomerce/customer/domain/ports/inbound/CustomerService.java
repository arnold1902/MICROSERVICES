package com.microservices.ecomerce.customer.domain.ports.inbound;

import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
	CustomerDto save(CustomerDto customerDto);
	CustomerDto update(String id, CustomerDto customerDto);
	Optional<CustomerDto> findById(String id);
	List<CustomerDto> findAll();
	void deleteById(String id);
}
