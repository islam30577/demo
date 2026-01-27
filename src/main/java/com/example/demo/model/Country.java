package com.example.demo.model;

public class Country {

    private Long id;
    private String countryFull;
    private String countryShort;

    public Country() {}

    public Country(Long id, String countryFull, String countryShort) {
        this.id = id;
        this.countryFull = countryFull;
        this.countryShort = countryShort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryFull() {
        return countryFull;
    }

    public void setCountryFull(String countryFull) {
        this.countryFull = countryFull;
    }

    public String getCountryShort() {
        return countryShort;
    }

    public void setCountryShort(String countryShort) {
        this.countryShort = countryShort;
    }
}