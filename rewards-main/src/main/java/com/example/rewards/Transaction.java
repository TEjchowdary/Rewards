package com.example.rewards;

import java.time.LocalDate;

public class Transaction
{
    private long id;
    private String customerId;
    private double amount;
    private LocalDate date;

    public Transaction() {
        // Default constructor
    }

    public Transaction(long id, String customerId, double amount, LocalDate date) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
