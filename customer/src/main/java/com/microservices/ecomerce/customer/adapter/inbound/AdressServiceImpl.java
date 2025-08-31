package com.microservices.ecomerce.customer.adapter.inbound;

import com.microservices.ecomerce.customer.domain.ports.inbound.AdressService;
import com.microservices.ecomerce.customer.domain.ports.outbound.AdressRepository;
import com.microservices.ecomerce.customer.application.dto.AdressDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressServiceImpl implements AdressService {
    private final AdressRepository adressRepository;

    public AdressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public AdressDto save(AdressDto adressDto) {
        return adressRepository.save(adressDto);
    }

    @Override
    public Optional<AdressDto> findById(String id) {
        return adressRepository.findById(id);
    }

    @Override
    public List<AdressDto> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public AdressDto update(String id, AdressDto adressDto) {
        Optional<AdressDto> existing = adressRepository.findById(id);
        if (existing.isEmpty()) {
            throw new com.microservices.ecomerce.customer.infrastructure.exceptions.NotFoundException("Adress not found with id: " + id);
        }
        AdressDto updated = adressDto;
        return adressRepository.save(updated);
    }

    public void deleteById(String id) {
        adressRepository.deleteById(id);
    }
}
