package com.microservices.ecommerce.product.infrastructure.persistence;

import com.microservices.ecommerce.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
