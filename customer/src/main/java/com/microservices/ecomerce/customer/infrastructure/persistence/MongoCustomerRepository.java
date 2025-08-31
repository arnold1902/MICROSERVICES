package com.microservices.ecomerce.customer.infrastructure.persistence;

import com.microservices.ecomerce.customer.domain.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoCustomerRepository extends MongoRepository<Customer, String> {
}
