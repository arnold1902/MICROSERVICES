package com.microservices.ecomerce.customer.domain.ports.inbound;

import com.microservices.ecomerce.customer.application.dto.AdressDto;
import java.util.List;
import java.util.Optional;

public interface AdressService {
    AdressDto save(AdressDto adressDto);
    AdressDto update(String id, AdressDto adressDto);
    Optional<AdressDto> findById(String id);
    List<AdressDto> findAll();
    void deleteById(String id);
}
