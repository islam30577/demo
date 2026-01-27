package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    
    @Id
    private Long id;
    private String person;
    private Long cityId;  
    private String street;
    private String building;
    private String office;
}