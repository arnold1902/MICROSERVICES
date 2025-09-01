package com.microservices.ecommerce.product.domain.ports.outbound;

import com.microservices.ecommerce.product.application.dto.CategoryDto;

import java.util.List;

public interface CategoryRepository {
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    CategoryDto save(CategoryDto categoryDto);
    void deleteById(Long id);
    CategoryDto update(Long id, CategoryDto categoryDto);
}
