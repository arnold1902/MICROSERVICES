package com.microservices.ecomerce.customer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    @DBRef
    private Adress adress;
}
