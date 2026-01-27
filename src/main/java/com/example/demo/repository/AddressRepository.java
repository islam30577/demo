package com.example.demo.repository;

import com.example.demo.model.Address;
import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    List<Address> findAll();
    Optional<Address> findById(Long id);
    Address save(Address address);
    void deleteById(Long id);
    List<Address> findByPersonContaining(String person);
}