package com.microservices.ecomerce.customer.infrastructure.mappers;

import com.microservices.ecomerce.customer.domain.model.Customer;
import com.microservices.ecomerce.customer.application.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AdressMapper.class})
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDto dto);
    CustomerDto toDto(Customer entity);
}
