package com.microservices.ecomerce.customer.adapter.outbound;

import com.microservices.ecomerce.customer.domain.model.Adress;
import com.microservices.ecomerce.customer.application.dto.AdressDto;
import com.microservices.ecomerce.customer.infrastructure.mappers.AdressMapper;
import com.microservices.ecomerce.customer.domain.ports.outbound.AdressRepository;
import com.microservices.ecomerce.customer.adapter.persistence.MongoAdressRepository;
import com.microservices.ecomerce.customer.infrastructure.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdressRepositoryAdapter implements AdressRepository {
    private final MongoAdressRepository mongoAdressRepository;
    private final AdressMapper adressMapper;

    public AdressRepositoryAdapter(MongoAdressRepository mongoAdressRepository, AdressMapper adressMapper) {
        this.mongoAdressRepository = mongoAdressRepository;
        this.adressMapper = adressMapper;
    }

    @Override
    public AdressDto save(AdressDto adressDto) {
        Adress adress = adressMapper.toEntity(adressDto);
        Adress saved = mongoAdressRepository.save(adress);
        return adressMapper.toDto(saved);
    }

    @Override
    public Optional<AdressDto> findById(String id) {
        return mongoAdressRepository.findById(id)
                .map(adressMapper::toDto);
    }

    @Override
    public List<AdressDto> findAll() {
        return mongoAdressRepository.findAll().stream()
                .map(adressMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        if (!mongoAdressRepository.existsById(id)) {
            throw new NotFoundException("Adress not found with id: " + id);
        }
        mongoAdressRepository.deleteById(id);
    }
}
