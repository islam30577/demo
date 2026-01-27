package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    
    @NotNull(message = "ID страны обязателен")
    private Long countryId;
    
    @NotBlank(message = "Название региона обязательно")
    @Size(min = 3, message = "Название региона должно содержать минимум 3 символа")
    private String region;
}