package com.mycompany.devops_project;

public class Item {
    private double shippingWeight;
    private String description;
    private double unitPrice;
    private int stock;

    public Item(double shippingWeight, String description, double unitPrice, int stock) {
        this.shippingWeight = shippingWeight;
        this.description = description;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceForQuantity(int quantity) {
        return unitPrice * quantity;
    }

    public double getTax() {
        return unitPrice * 0.10; // 10% tax
    }

    public boolean inStock(int quantity) {
        return stock >= quantity;
    }
}