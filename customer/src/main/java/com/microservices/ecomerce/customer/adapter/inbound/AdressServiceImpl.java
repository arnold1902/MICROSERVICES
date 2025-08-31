package com.microservices.ecomerce.customer.adapter.inbound;

import com.microservices.ecomerce.customer.infrastructure.exceptions.NotFoundException;
import com.microservices.ecomerce.customer.domain.ports.inbound.AdressService;
import com.microservices.ecomerce.customer.domain.ports.outbound.AdressRepository;
import com.microservices.ecomerce.customer.application.dto.AdressDto;
import com.microservices.ecomerce.customer.infrastructure.utils.DtoMergeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public AdressDto findById(String id) {
        return adressRepository.findById(id);
    }

    @Override
    public List<AdressDto> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public AdressDto update(String id, AdressDto adressDto) {
        AdressDto existing = adressRepository.findById(id);
        if (existing == null) {
            throw new NotFoundException("Adress not found with id: " + id);
        }
        AdressDto merged = DtoMergeUtil.mergeAdress(existing, adressDto);
        return adressRepository.save(merged);
    }

    public void deleteById(String id) {
        adressRepository.deleteById(id);
    }
}
