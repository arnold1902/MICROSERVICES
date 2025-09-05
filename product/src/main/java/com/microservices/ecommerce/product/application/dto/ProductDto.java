
package com.microservices.ecommerce.product.application.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDto(
    Long id,
    @NotBlank(message = "Le nom du produit ne doit pas être vide") 
    String name,

    @NotNull(message = "Le prix ne doit pas être nul")
    @Positive(message = "Le prix doit être positif")
    BigDecimal price,

    @NotNull(message = "La catégorie ne doit pas être nulle")
    CategoryDto category
) {}
