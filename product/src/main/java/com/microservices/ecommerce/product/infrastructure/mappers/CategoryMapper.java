package com.microservices.ecommerce.product.infrastructure.mappers;

import com.microservices.ecommerce.product.domain.model.Category;
import com.microservices.ecommerce.product.application.dto.CategoryDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}
