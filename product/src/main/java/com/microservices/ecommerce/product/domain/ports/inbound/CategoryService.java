package com.microservices.ecommerce.product.domain.ports.inbound;

import com.microservices.ecommerce.product.application.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory(CategoryDto categoryDto);
    void deleteCategory(Long id);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
}
