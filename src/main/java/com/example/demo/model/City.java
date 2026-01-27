package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table("cities")
@NoArgsConstructor
@AllArgsConstructor
public class City {
    
    @Id
    private Long id;
    private Long regionId;  
    private String city;
}