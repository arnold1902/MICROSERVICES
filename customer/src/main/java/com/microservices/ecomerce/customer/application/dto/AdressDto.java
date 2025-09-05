package com.microservices.ecomerce.customer.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdressDto(
    @NotBlank(message = "La rue ne doit pas être vide") 
    @Size(max = 100, message = "La taille de la rue ne doit pas depasser 100") 
    String street,

    @NotBlank(message = "La ville ne doit pas être vide") 
    @Size(max = 50, message = "La taille de la ville ne doit pas depasser 50") 
    String city,

    @NotBlank(message = "Le pays ne doit pas être vide") 
    @Size(max = 50, message = "La taille du pays ne doit pas depasser 50") 
    String country,

    @NotBlank(message = "Le code postal ne doit pas être vide") 
    @Size(max = 20, message = "La taille du code postal ne doit pas depasser 20") 
    String zipCode
) {}
