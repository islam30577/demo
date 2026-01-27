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
@Table("cities")
@NoArgsConstructor
@AllArgsConstructor
public class City {
    
    @Id
    private Long id;
    
    @NotNull(message = "ID региона обязателен")
    private Long regionId;
    
    @NotBlank(message = "Название города обязательно")
    @Size(min = 2, message = "Название города должно содержать минимум 2 символа")
    private String city;
}