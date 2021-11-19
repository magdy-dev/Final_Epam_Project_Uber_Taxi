package com.magdy.taxiwebappliction.entity;

import java.io.Serializable;
import java.util.Objects;

public class Ride  implements Serializable {


    private long id;
    private Address addressFrom;
    private Address addressTo;
    private Order order;

    public Ride() {
    }

    public Ride(long id, Address addressFrom, Address addressTo, Order order) {
        this.id = id;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.order = order;
    }

    public Ride(Address addressFrom, Address addressTo, Order order) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.order = order;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(Address addressIdFrom) {
        this.addressFrom = addressIdFrom;
    }

    public Address getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(Address addressIdTo) {
        this.addressTo = addressIdTo;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order orderId) {
        this.order = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return id == ride.id && Objects.equals(addressFrom, ride.addressFrom) && Objects.equals(addressTo, ride.addressTo) && Objects.equals(order, ride.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressFrom, addressTo, order);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", addressIdFrom=" + addressFrom +
                ", addressIdTo=" + addressTo +
                ", orderId=" + order +
                '}';
    }
}
