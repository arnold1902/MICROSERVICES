package com.microservices.ecomerce.customer.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerDto(
    @NotBlank(message = "Le prénom ne doit pas être vide") 
    @Size(max = 50, message = "La taille du prénom ne doit pas depasser 50") 
    String firstName,

    @NotBlank(message = "Le nom de famille ne doit pas être vide") 
    @Size(max = 50, message = "La taille du nom de famille ne doit pas depasser 50") 
    String lastName,

    @Email(message = "L'email doit être valide") 
    @NotBlank(message = "L'email ne doit pas être vide") 
    String email,
    
    AdressDto adress
) {}
