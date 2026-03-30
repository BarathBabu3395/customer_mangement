package com.mycompany.devops_project;
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

    public boolean authorized() {
        return expDate != null && !expDate.isEmpty();
    }
}