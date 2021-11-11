package com.magdy.taxiwebappliction.entity;

import java.util.Objects;



public class Address {

    private long id;
    private String town;
    private String street;
    private int building;


    public Address() {

    }

    public Address(long id) {
        this.id = id;
    }

    public Address(String town, String street, int building) {
        this.town = town;
        this.street = street;
        this.building = building;
    }

    public Address(long id, String town, String street, int building) {
        this.id = id;
        this.town = town;
        this.street = street;
        this.building = building;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && building == address.building && Objects.equals(town, address.town) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, town, street, building);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                '}';
    }
}
