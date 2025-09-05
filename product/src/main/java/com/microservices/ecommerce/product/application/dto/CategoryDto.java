
package com.microservices.ecommerce.product.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryDto(
    Long id,
    
    @NotBlank(message = "Le nom de la catégorie ne doit pas être vide") 
    String name
) {}
