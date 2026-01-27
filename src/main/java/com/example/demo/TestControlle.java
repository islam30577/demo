package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.model.Address;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {
    
    // Используем JdbcTemplate реализации напрямую
    private final JdbcCountryRepository countryRepository;
    private final JdbcAddressRepository addressRepository;
    
    @Autowired
    public TestController(JdbcCountryRepository countryRepository, 
                         JdbcAddressRepository addressRepository) {
        this.countryRepository = countryRepository;
        this.addressRepository = addressRepository;
    }
    
    @GetMapping("/test/jdbc")
    public String testJdbcPage(Model model) {
        List<Country> countries = countryRepository.findAll();  // Метод из JdbcCountryRepository
        List<Address> addresses = addressRepository.findAll();  // Метод из JdbcAddressRepository
        
        model.addAttribute("countries", countries);
        model.addAttribute("addresses", addresses);
        
        return "test-jdbc";
    }
    
    @PostMapping("/test/jdbc/add-country")
    public String addCountry(
            @RequestParam String countryFull,
            @RequestParam String countryShort,
            Model model) {
        
        Country country = new Country();
        country.setCountryFull(countryFull);
        country.setCountryShort(countryShort);
        countryRepository.save(country);
        
        return "redirect:/test/jdbc";
    }
    
    @PostMapping("/test/jdbc/add-address")
    public String addAddress(
            @RequestParam String person,
            @RequestParam Long cityId,
            @RequestParam String street,
            @RequestParam String building,
            @RequestParam String office,
            Model model) {
        
        Address address = new Address();
        address.setPerson(person);
        address.setCityId(cityId);
        address.setStreet(street);
        address.setBuilding(building);
        address.setOffice(office);
        addressRepository.save(address);
        
        return "redirect:/test/jdbc";
    }
    
    @GetMapping("/test/jdbc/search")
    public String searchAddresses(
            @RequestParam(required = false) String search,
            Model model) {
        
        List<Address> addresses;
        if (search != null && !search.trim().isEmpty()) {
            addresses = addressRepository.findByPersonContaining(search);
            model.addAttribute("searchQuery", search);
        } else {
            addresses = addressRepository.findAll();
        }
        
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("addresses", addresses);
        
        return "test-jdbc";
    }
}