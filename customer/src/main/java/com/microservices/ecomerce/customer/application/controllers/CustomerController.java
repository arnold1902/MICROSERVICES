package com.microservices.ecomerce.customer.application.controllers;

import com.microservices.ecomerce.customer.domain.ports.inbound.CustomerService;
import com.microservices.ecomerce.customer.application.dto.CategoryDto;
import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import com.microservices.ecomerce.customer.application.dto.ProductDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
	private final CustomerService customerService;
	private final RestTemplate restTemplate;
	private static final String CBNAME = "customerCB";

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
	// @CircuitBreaker(name = CBNAME, fallbackMethod = "fallBackGetProduct")
	// @Retry(name = CBNAME, fallbackMethod = "fallBackGetProduct")
	@RateLimiter(name = CBNAME, fallbackMethod = "fallBackGetProduct")
	public ResponseEntity<ProductDto> getProduct(@PathVariable String id) {
		ProductDto productDto = restTemplate.getForObject("http://gateway:8222/api/products/" + id, ProductDto.class);
		return ResponseEntity.ok(productDto);
	}

	public ResponseEntity<ProductDto> fallBackGetProduct(Exception e) {
		return new ResponseEntity<>(
			new ProductDto(
				0L, 
				"Produit de fallback", 
				BigDecimal.ZERO, 
				new CategoryDto(
					0L, "Catégorie de fallback"
				)
			), HttpStatus.OK);
	}
}
