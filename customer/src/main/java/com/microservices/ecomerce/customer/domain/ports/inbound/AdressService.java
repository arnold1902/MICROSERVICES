package com.microservices.ecomerce.customer.domain.ports.inbound;

import com.microservices.ecomerce.customer.application.dto.AdressDto;
import java.util.List;

public interface AdressService {
    AdressDto save(AdressDto adressDto);
    AdressDto update(String id, AdressDto adressDto);
    AdressDto findById(String id);
    List<AdressDto> findAll();
    void deleteById(String id);
}
