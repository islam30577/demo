package com.example.demo.model;

public class City {

    private Long id;
    private Region region;
    private String city;

    public City() {}

    public City(Long id, Region region, String city) {
        this.id = id;
        this.region = region;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}