package com.mycompany.devops_project;

import java.util.Date;

public class Devops_project {
    public static void main(String[] args) {
        Customer customer = new Customer("Barath", "Ranipet");

        Item item1 = new Item(2.5, "Laptop Bag", 1000, 10);
        Item item2 = new Item(1.0, "Mouse", 500, 20);

        OrderDetail od1 = new OrderDetail(2, "TAXABLE", item1);
        OrderDetail od2 = new OrderDetail(1, "TAXABLE", item2);

        Order order = new Order(new Date(), "NEW", customer);
        order.addOrderDetail(od1);
        order.addOrderDetail(od2);

        Credit payment = new Credit((float) order.calcTotal(), "Barath", "VISA", "12/28");
        order.setPayment(payment);

        order.displayOrder();
    }
}