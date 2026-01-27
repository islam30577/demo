package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.model.Region;
import com.example.demo.model.City;
import com.example.demo.repository.JdbcCountryRepository;
import com.example.demo.repository.RegionRepository;
import com.example.demo.repository.CityRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/geodata")
public class GeoDataController {
    
    private final JdbcCountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;
    
    public GeoDataController(JdbcCountryRepository countryRepository,
                           RegionRepository regionRepository,
                           CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.cityRepository = cityRepository;
    }
    
    @GetMapping
    public String showGeoData(Model model) {
        model.addAttribute("countries", countryRepository.findAll());
        model.addAttribute("regions", regionRepository.findAll());
        model.addAttribute("cities", cityRepository.findAll());
        return "geodata";
    }
    
    // Страны
    @GetMapping("/countries/add")
    public String showAddCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "add-country";
    }
    
    @PostMapping("/countries/add")
    public String addCountry(@Valid @ModelAttribute Country country, Errors errors) {
        if (errors.hasErrors()) {
            return "add-country";
        }
        
        countryRepository.save(country);
        log.info("Добавлена страна: {}", country);
        return "redirect:/geodata";
    }
    
    @GetMapping("/countries/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
        log.info("Удалена страна с ID: {}", id);
        return "redirect:/geodata";
    }
    
    // Регионы
    @GetMapping("/regions/add")
    public String showAddRegionForm(Model model) {
        model.addAttribute("region", new Region());
        model.addAttribute("countries", countryRepository.findAll());
        return "add-region";
    }
    
    @PostMapping("/regions/add")
    public String addRegion(@Valid @ModelAttribute Region region, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("countries", countryRepository.findAll());
            return "add-region";
        }
        
        regionRepository.save(region);
        log.info("Добавлен регион: {}", region);
        return "redirect:/geodata";
    }
    
    @GetMapping("/regions/delete/{id}")
    public String deleteRegion(@PathVariable Long id) {
        regionRepository.deleteById(id);
        log.info("Удален регион с ID: {}", id);
        return "redirect:/geodata";
    }
    
    // Города
    @GetMapping("/cities/add")
    public String showAddCityForm(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("regions", regionRepository.findAll());
        return "add-city";
    }
    
    @PostMapping("/cities/add")
    public String addCity(@Valid @ModelAttribute City city, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("regions", regionRepository.findAll());
            return "add-city";
        }
        
        cityRepository.save(city);
        log.info("Добавлен город: {}", city);
        return "redirect:/geodata";
    }
    
    @GetMapping("/cities/delete/{id}")
    public String deleteCity(@PathVariable Long id) {
        cityRepository.deleteById(id);
        log.info("Удален город с ID: {}", id);
        return "redirect:/geodata";
    }
}