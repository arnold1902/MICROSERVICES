package com.microservices.ecomerce.customer.domain.ports.outbound;

import com.microservices.ecomerce.customer.application.dto.AdressDto;
import java.util.List;

public interface AdressRepository {
    AdressDto save(AdressDto adress);
    AdressDto findById(String id);
    List<AdressDto> findAll();
    void deleteById(String id);
}
