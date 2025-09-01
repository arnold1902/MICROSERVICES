package com.microservices.ecommerce.product.adapter.outbound;

import com.microservices.ecommerce.product.application.dto.CategoryDto;
import com.microservices.ecommerce.product.domain.model.Category;
import com.microservices.ecommerce.product.domain.ports.outbound.CategoryRepository;
import com.microservices.ecommerce.product.infrastructure.persistence.JpaCategoryRepository;

import lombok.RequiredArgsConstructor;

import com.microservices.ecommerce.product.infrastructure.mappers.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

	private final JpaCategoryRepository jpaCategoryRepository;
	private final CategoryMapper categoryMapper;

	@Override
	public List<CategoryDto> findAll() {
		return jpaCategoryRepository.findAll().stream()
				.map(categoryMapper::toDto)
				.toList();
	}

	@Override
	public CategoryDto findById(Long id) {
		return jpaCategoryRepository.findById(id)
				.map(categoryMapper::toDto)
				.orElse(null);
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		Category category = categoryMapper.toEntity(categoryDto);
		Category saved = jpaCategoryRepository.save(category);
		return categoryMapper.toDto(saved);
	}

	@Override
	public void deleteById(Long id) {
		jpaCategoryRepository.deleteById(id);
	}

	@Override
	public CategoryDto update(Long id, CategoryDto categoryDto) {
		Category category = categoryMapper.toEntity(categoryDto);
		category = jpaCategoryRepository.save(category);
		return categoryMapper.toDto(category);
	}
}
