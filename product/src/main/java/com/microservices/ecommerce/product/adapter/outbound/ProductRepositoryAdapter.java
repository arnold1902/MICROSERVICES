package com.microservices.ecommerce.product.adapter.outbound;

import com.microservices.ecommerce.product.application.dto.ProductDto;
import com.microservices.ecommerce.product.domain.model.Product;
import com.microservices.ecommerce.product.domain.ports.outbound.ProductRepository;
import com.microservices.ecommerce.product.infrastructure.persistence.JpaProductRepository;

import lombok.RequiredArgsConstructor;

import com.microservices.ecommerce.product.infrastructure.mappers.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto findById(Long id) {
        return jpaProductRepository.findById(id)
                .map(productMapper::toDto)
                .orElse(null);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product saved = jpaProductRepository.save(product);
        return productMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product = jpaProductRepository.save(product);
        return productMapper.toDto(product);
    }
}
