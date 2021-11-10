package com.magdy.taxiwebappliction.entity;

import java.util.Objects;

public class Driver {

    private long id;
    private String name;
    private String lastName;
    private String carNumber;
    private String email;
    private String password;
    private String phoneNumber;

    public Driver() {
    }

    public Driver(long id) {
        this.id = id;
    }

    public Driver(long id, String name, String lastName, String carNumber, String email, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.carNumber = carNumber;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Driver(String name, String lastName, String carNumber, String email, String password, String phoneNumber) {
        this.name = name;
        this.lastName = name;
        this.carNumber = carNumber;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id && Objects.equals(name, driver.name) && Objects.equals(lastName, driver.lastName) && Objects.equals(carNumber, driver.carNumber) && Objects.equals(email, driver.email) && Objects.equals(password, driver.password) && Objects.equals(phoneNumber, driver.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, carNumber, email, password, phoneNumber);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
