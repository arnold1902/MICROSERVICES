package com.microservices.ecomerce.customer.application.controllers;

import com.microservices.ecomerce.customer.domain.ports.inbound.CustomerService;
import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<CustomerDto> create(@Valid @RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(customerService.save(customerDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getById(@PathVariable String id) {
		return customerService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAll() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> update(@PathVariable String id, @Valid @RequestBody CustomerDto customerDto) {
		return ResponseEntity.ok(customerService.update(id, customerDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		customerService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
