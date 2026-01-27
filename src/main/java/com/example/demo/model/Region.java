package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("regions")
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    
    @Id
    private Long id;
    private Long countryId;  
    private String region;
}