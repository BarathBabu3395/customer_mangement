package com.mycompany.customermanagement.model;

import com.mycompany.customermanagement.enums.TaxStatus;

public class OrderDetail {
    private int quantity;
    private TaxStatus taxStatus;
    private Item item;

    public OrderDetail(int quantity, TaxStatus taxStatus, Item item) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (!item.inStock(quantity)) {
            throw new IllegalArgumentException("Insufficient stock for item: " + item.getDescription());
        }
        this.quantity = quantity;
        this.taxStatus = taxStatus;
        this.item = item;
    }

    public double calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public double calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public double calcTax() {
        return taxStatus == TaxStatus.TAXABLE ? item.getTax() * quantity : 0.0;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }
}