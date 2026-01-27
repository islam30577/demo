package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    
    @Id
    private Long id;
    private String countryFull;
    private String countryShort;
}