package com.mycompany.customermanagement.model;

public class Check extends Payment {
    private String name;
    private String bankID;

    public Check(float amount, String name, String bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }

    @Override
    public boolean authorized() {
        return name != null && !name.isBlank() &&
               bankID != null && !bankID.isBlank();
    }
}