package com.microservices.ecomerce.customer.infrastructure.utils;

import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import com.microservices.ecomerce.customer.application.dto.AdressDto;

public class DtoMergeUtil {

    private DtoMergeUtil() {}

    public static CustomerDto mergeCustomer(CustomerDto source, CustomerDto update) {
        return new CustomerDto(
            update.firstName() != null ? update.firstName() : source.firstName(),
            update.lastName() != null ? update.lastName() : source.lastName(),
            update.email() != null ? update.email() : source.email(),
            update.adress() != null ? update.adress() : source.adress()
        );
    }

    public static AdressDto mergeAdress(AdressDto source, AdressDto update) {
        return new AdressDto(
            update.street() != null ? update.street() : source.street(),
            update.city() != null ? update.city() : source.city(),
            update.country() != null ? update.country() : source.country(),
            update.zipCode() != null ? update.zipCode() : source.zipCode()
        );
    }
}
