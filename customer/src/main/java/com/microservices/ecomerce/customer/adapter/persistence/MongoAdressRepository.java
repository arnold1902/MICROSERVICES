package com.microservices.ecomerce.customer.adapter.persistence;

import com.microservices.ecomerce.customer.domain.model.Adress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAdressRepository extends MongoRepository<Adress, String> {
}
