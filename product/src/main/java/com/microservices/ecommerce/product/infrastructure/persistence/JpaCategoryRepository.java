package com.microservices.ecommerce.product.infrastructure.persistence;

import com.microservices.ecommerce.product.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Long> {
}
