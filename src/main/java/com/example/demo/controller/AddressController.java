package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.repository.JdbcAddressRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/addresses")
public class AddressController {
    
    private final JdbcAddressRepository addressRepository;
    
    public AddressController(JdbcAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    
    @GetMapping
    public String showAddresses(Model model) {
        model.addAttribute("addresses", addressRepository.findAll());
        return "addresses";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("address", new Address());
        return "add-address";
    }
    
    @PostMapping("/add")
    public String addAddress(@Valid @ModelAttribute Address address, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.error("Ошибки валидации при добавлении адреса: {}", errors.getAllErrors());
            return "add-address";
        }
        
        addressRepository.save(address);
        log.info("Добавлен адрес: {}", address);
        return "redirect:/addresses";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        addressRepository.findById(id).ifPresent(address -> 
            model.addAttribute("address", address));
        return "edit-address";
    }
    
    @PostMapping("/edit/{id}")
    public String updateAddress(@PathVariable Long id, @Valid @ModelAttribute Address address, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Ошибки валидации при обновлении адреса: {}", errors.getAllErrors());
            return "edit-address";
        }
        
        address.setId(id);
        addressRepository.save(address);
        log.info("Обновлен адрес с ID {}: {}", id, address);
        return "redirect:/addresses";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
        log.info("Удален адрес с ID: {}", id);
        return "redirect:/addresses";
    }
    
    @GetMapping("/search")
    public String searchAddresses(@RequestParam(required = false) String search, Model model) {
        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("addresses", addressRepository.findByPersonContaining(search));
            model.addAttribute("searchQuery", search);
        } else {
            model.addAttribute("addresses", addressRepository.findAll());
        }
        return "addresses";
    }
}