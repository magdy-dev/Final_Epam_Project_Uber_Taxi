package com.magdy.taxiwebappliction.entity;

import java.util.Objects;

public class Order {


    private long id;
    private String data;
    private Client client;
    private Driver driver;

    public Order(long id) {
        this.id = id;
    }

    public Order(long id, String data, Client client, Driver driver) {
        this.id = id;
        this.data = data;
        this.client = client;
        this.driver = driver;
    }

    public Order(String data, Client client, Driver driver) {
        this.data = data;
        this.client = client;
        this.driver = driver;
    }

    public Order() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(data, order.data) && Objects.equals(client, order.client) && Objects.equals(driver, order.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, client, driver);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", client=" + client +
                ", driver=" + driver +
                '}';
    }
}
