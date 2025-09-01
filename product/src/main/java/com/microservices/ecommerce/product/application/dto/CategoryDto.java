
package com.microservices.ecommerce.product.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDto(
    Long id,
    @NotBlank String name
) {}
