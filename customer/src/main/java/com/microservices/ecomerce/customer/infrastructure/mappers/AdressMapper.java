package com.microservices.ecomerce.customer.infrastructure.mappers;

import com.microservices.ecomerce.customer.domain.model.Adress;
import com.microservices.ecomerce.customer.application.dto.AdressDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdressMapper {
    AdressMapper INSTANCE = Mappers.getMapper(AdressMapper.class);

    @Mapping(target = "id", ignore = true)
    Adress toEntity(AdressDto dto);
    AdressDto toDto(Adress entity);
}