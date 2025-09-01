package com.microservices.ecommerce.product.adapter.inbound;

import com.microservices.ecommerce.product.infrastructure.utils.DtoMergeUtil;
import com.microservices.ecommerce.product.domain.ports.inbound.ProductService;
import com.microservices.ecommerce.product.domain.ports.outbound.ProductRepository;
import com.microservices.ecommerce.product.application.dto.ProductDto;
import com.microservices.ecommerce.product.infrastructure.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return productRepository.save(productDto);
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductDto product = productRepository.findById(id);
        if (product == null) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        return product;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = productRepository.findAll();
        if (products == null || products.isEmpty()) {
            throw new NotFoundException("No products found.");
        }
        return products;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        ProductDto existing = productRepository.findById(id);
        if (existing == null) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        ProductDto merged = DtoMergeUtil.mergeProduct(existing, productDto);
        return productRepository.save(merged);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
