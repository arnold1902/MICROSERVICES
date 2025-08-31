package com.microservices.ecomerce.customer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "adresses")
public class Adress {
    @Id
    private String id;
    private String street;
    private String city;
    private String country;
    private String zipCode;
}
