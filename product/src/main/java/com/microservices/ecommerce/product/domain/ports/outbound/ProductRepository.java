package com.microservices.ecommerce.product.domain.ports.outbound;

import com.microservices.ecommerce.product.application.dto.ProductDto;

import java.util.List;

public interface ProductRepository {
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto save(ProductDto productDto);
    void deleteById(Long id);
    ProductDto update(Long id, ProductDto productDto);
}
