package com.mycompany.customermanagement.model;

public class Cash extends Payment {
    private float cashTendered;

    public Cash(float amount, float cashTendered) {
        super(amount);
        if (cashTendered < amount) {
            throw new IllegalArgumentException("Cash tendered is less than payment amount");
        }
        this.cashTendered = cashTendered;
    }

    public float getCashTendered() {
        return cashTendered;
    }

    @Override
    public boolean authorized() {
        return cashTendered >= amount;
    }
}