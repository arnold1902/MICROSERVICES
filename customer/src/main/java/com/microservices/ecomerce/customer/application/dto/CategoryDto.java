package com.microservices.ecomerce.customer.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDto(
    Long id,
    @NotBlank String name
) {}
