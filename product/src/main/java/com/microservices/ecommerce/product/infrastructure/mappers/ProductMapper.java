package com.microservices.ecommerce.product.infrastructure.mappers;

import com.microservices.ecommerce.product.domain.model.Product;
import com.microservices.ecommerce.product.application.dto.ProductDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
