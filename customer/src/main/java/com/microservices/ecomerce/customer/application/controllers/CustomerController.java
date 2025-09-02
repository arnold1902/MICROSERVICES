package com.microservices.ecomerce.customer.application.controllers;

import com.microservices.ecomerce.customer.domain.ports.inbound.CustomerService;
import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import com.microservices.ecomerce.customer.application.dto.ProductDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
	private final CustomerService customerService;
	private final RestTemplate restTemplate;

	@PostMapping
	public ResponseEntity<CustomerDto> create(@Valid @RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(customerService.save(customerDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getById(@PathVariable String id) {
		return ResponseEntity.ok(customerService.findById(id));
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

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable String id) {
		ProductDto productDto = restTemplate.getForObject("http://localhost:8222/api/products/" + id, ProductDto.class);
		return ResponseEntity.ok(productDto);
	}
}
