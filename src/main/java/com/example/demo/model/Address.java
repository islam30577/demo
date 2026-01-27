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
@Table("addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    
    @Id
    private Long id;
    
    @NotBlank(message = "ФИО обязательно")
    @Size(min = 5, message = "ФИО должно содержать минимум 5 символов")
    private String person;
    
    @NotNull(message = "ID города обязателен")
    private Long cityId;
    
    @NotBlank(message = "Улица обязательна")
    private String street;
    
    @NotBlank(message = "Дом обязателен")
    private String building;
    
    private String office;
}