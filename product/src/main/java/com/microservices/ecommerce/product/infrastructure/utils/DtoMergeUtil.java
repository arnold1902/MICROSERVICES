package com.microservices.ecommerce.product.infrastructure.utils;

import com.microservices.ecommerce.product.application.dto.ProductDto;
import com.microservices.ecommerce.product.application.dto.CategoryDto;

public class DtoMergeUtil {
    private DtoMergeUtil() {}

    public static ProductDto mergeProduct(ProductDto source, ProductDto update) {
        CategoryDto mergedCategory = new CategoryDto(
            update.category().id() != null ? update.category().id() : source.category().id(),
            update.category().name() != null ? update.category().name() : source.category().name()
        );
        return new ProductDto(
            update.id() != null ? update.id() : source.id(),
            update.name() != null ? update.name() : source.name(),
            update.price(),
            mergedCategory
        );
    }

    public static CategoryDto mergeCategory(CategoryDto source, CategoryDto update) {
        return new CategoryDto(
            update.id() != null ? update.id() : source.id(),
            update.name() != null ? update.name() : source.name()
        );
    }
}
