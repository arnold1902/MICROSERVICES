package com.microservices.ecommerce.product.domain.ports.inbound;

import com.microservices.ecommerce.product.application.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    void deleteProduct(Long id);
    ProductDto updateProduct(Long id, ProductDto productDto);
}
