package com.example.demo.model;

public class Address {

    private Long id;
    private String person;
    private City city;
    private String street;
    private String building;
    private String office;

    public Address() {}

    public Address(Long id, String person, City city, String street, String building, String office) {
        this.id = id;
        this.person = person;
        this.city = city;
        this.street = street;
        this.building = building;
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}