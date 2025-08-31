package com.microservices.ecomerce.customer.infrastructure.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
