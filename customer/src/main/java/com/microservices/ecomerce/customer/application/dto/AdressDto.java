package com.microservices.ecomerce.customer.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdressDto(
    @NotBlank @Size(max = 100) String street,
    @NotBlank @Size(max = 50) String city,
    @NotBlank @Size(max = 50) String country,
    @NotBlank @Size(max = 20) String zipCode
) {}
