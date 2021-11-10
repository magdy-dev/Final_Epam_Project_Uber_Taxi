package com.magdy.taxiwebappliction.entity;

import java.util.Objects;

public class Ride {


    private long id;
    private Address addressIdFrom;
    private Address addressIdTo;
    private Order orderId;

    public Ride() {
    }

    public Ride(long id, Address addressIdFrom, Address addressIdTo, Order orderId) {
        this.id = id;
        this.addressIdFrom = addressIdFrom;
        this.addressIdTo = addressIdTo;
        this.orderId = orderId;
    }

    public Ride(Address addressIdFrom, Address addressIdTo, Order orderId) {
        this.addressIdFrom = addressIdFrom;
        this.addressIdTo = addressIdTo;
        this.orderId = orderId;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddressIdFrom() {
        return addressIdFrom;
    }

    public void setAddressIdFrom(Address addressIdFrom) {
        this.addressIdFrom = addressIdFrom;
    }

    public Address getAddressIdTo() {
        return addressIdTo;
    }

    public void setAddressIdTo(Address addressIdTo) {
        this.addressIdTo = addressIdTo;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return id == ride.id && Objects.equals(addressIdFrom, ride.addressIdFrom) && Objects.equals(addressIdTo, ride.addressIdTo) && Objects.equals(orderId, ride.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressIdFrom, addressIdTo, orderId);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", addressIdFrom=" + addressIdFrom +
                ", addressIdTo=" + addressIdTo +
                ", orderId=" + orderId +
                '}';
    }
}
