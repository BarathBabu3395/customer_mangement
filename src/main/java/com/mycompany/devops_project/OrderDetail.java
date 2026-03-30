package com.mycompany.devops_project;

public class OrderDetail {
    private int quantity;
    private String taxStatus;
    private Item item;

    public OrderDetail(int quantity, String taxStatus, Item item) {
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
        if ("TAXABLE".equalsIgnoreCase(taxStatus)) {
            return item.getTax() * quantity;
        }
        return 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }
}