package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    
    @NotBlank(message = "Полное название страны обязательно")
    @Size(min = 3, message = "Название должно содержать минимум 3 символа")
    private String countryFull;
    
    @NotBlank(message = "Короткое название обязательно")
    @Size(min = 2, max = 10, message = "Короткое название должно быть от 2 до 10 символов")
    private String countryShort;
}