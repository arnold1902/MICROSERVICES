
package com.microservices.ecommerce.product.application.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDto(
    Long id,
    @NotBlank String name,
    @NotNull @Positive BigDecimal price,
    @NotNull CategoryDto category
) {}
