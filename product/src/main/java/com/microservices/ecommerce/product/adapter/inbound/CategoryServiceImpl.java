package com.microservices.ecommerce.product.adapter.inbound;

import com.microservices.ecommerce.product.infrastructure.utils.DtoMergeUtil;
import com.microservices.ecommerce.product.domain.ports.inbound.CategoryService;
import com.microservices.ecommerce.product.domain.ports.outbound.CategoryRepository;
import com.microservices.ecommerce.product.application.dto.CategoryDto;
import com.microservices.ecommerce.product.infrastructure.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return categoryRepository.save(categoryDto);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoryDto category = categoryRepository.findById(id);
        if (category == null) {
            throw new NotFoundException("Category not found with id: " + id);
        }
        return category;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categories = categoryRepository.findAll();
        if (categories == null || categories.isEmpty()) {
            throw new NotFoundException("No categories found.");
        }
        return categories;
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        CategoryDto existing = categoryRepository.findById(id);
        if (existing == null) {
            throw new NotFoundException("Category not found with id: " + id);
        }
        CategoryDto merged = DtoMergeUtil.mergeCategory(existing, categoryDto);
        return categoryRepository.save(merged);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
