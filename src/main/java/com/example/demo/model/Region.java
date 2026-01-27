package com.example.demo.model;

public class Region {

    private Long id;
    private Country country;
    private String region;

    public Region() {}

    public Region(Long id, Country country, String region) {
        this.id = id;
        this.country = country;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}