package com.magdy.taxiwebappliction.entity;

import java.io.Serializable;
import java.util.Objects;

public class Transaction implements Serializable {

    private long id;
    private  boolean cash;
    private Order order;
    private double amount;

    public Transaction() {
    }

    public Transaction(long id) {
        this.id = id;
    }

    public Transaction(long id, boolean cash, Order order, double amount) {
        this.id = id;
        this.cash = cash;
        this.order = order;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCash() {
        return cash;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && cash == that.cash && Double.compare(that.amount, amount) == 0 && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cash, order, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", cash=" + cash +
                ", orderId=" + order +
                ", amount=" + amount +
                '}';
    }
}
