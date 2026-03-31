package com.mycompany.customermanagement.model;

public class Credit extends Payment {
    private String name;
    private String type;
    private String expDate;

    public Credit(float amount, String name, String type, String expDate) {
        super(amount);
        this.name = name;
        this.type = type;
        this.expDate = expDate;
    }

    @Override
    public boolean authorized() {
        return name != null && !name.isBlank() &&
               type != null && !type.isBlank() &&
               expDate != null && !expDate.isBlank();
    }
}