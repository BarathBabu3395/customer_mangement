package com.mycompany.customermanagement.model;

public class Item {
    private double shippingWeight;
    private String description;
    private double unitPrice;
    private int availableStock;

    public Item(double shippingWeight, String description, double unitPrice, int availableStock) {
        if (shippingWeight < 0 || unitPrice < 0 || availableStock < 0) {
            throw new IllegalArgumentException("Invalid item values");
        }
        this.shippingWeight = shippingWeight;
        this.description = description;
        this.unitPrice = unitPrice;
        this.availableStock = availableStock;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceForQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        return unitPrice * quantity;
    }

    public double getTax() {
        return unitPrice * 0.10;
    }

    public boolean inStock(int quantity) {
        return availableStock >= quantity;
    }
}