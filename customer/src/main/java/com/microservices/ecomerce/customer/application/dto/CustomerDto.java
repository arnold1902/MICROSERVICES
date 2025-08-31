package com.microservices.ecomerce.customer.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerDto(
    @NotBlank @Size(max = 50) String firstName,
    @NotBlank @Size(max = 50) String lastName,
    @Email @NotBlank String email,
    AdressDto adress
) {}
