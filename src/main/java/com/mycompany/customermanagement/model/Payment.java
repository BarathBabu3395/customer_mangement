package com.mycompany.customermanagement.model;

public abstract class Payment {
    protected float amount;

    public Payment(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public abstract boolean authorized();
}