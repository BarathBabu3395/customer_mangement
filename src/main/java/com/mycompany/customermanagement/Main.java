package com.mycompany.customermanagement;

import com.mycompany.customermanagement.enums.OrderStatus;
import com.mycompany.customermanagement.enums.TaxStatus;
import com.mycompany.customermanagement.model.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Customer 1 - Barath
        Customer customer1 = new Customer("BarathKumar", "Vellore");

        Item laptopBag = new Item(2.5, "Laptop Bag", 1200.0, 10);
        Item mouse = new Item(0.5, "Wireless Mouse", 800.0, 20);

        OrderDetail detail1 = new OrderDetail(2, TaxStatus.TAXABLE, laptopBag);
        OrderDetail detail2 = new OrderDetail(1, TaxStatus.TAXABLE, mouse);

        Order order1 = new Order(new Date(), OrderStatus.NEW, customer1);
        order1.addOrderDetail(detail1);
        order1.addOrderDetail(detail2);

        Payment payment1 = new Credit((float) order1.calcTotal(), "Barath", "VISA", "12/28");
        order1.setPayment(payment1);

        order1.printInvoice();

        System.out.println();

        // Customer 2 - Lokeshkumar
        Customer customer2 = new Customer("Lokeshkumar", "Ranipet");

        Item keyboard = new Item(1.8, "Mechanical Keyboard", 2500.0, 15);
        Item headset = new Item(0.9, "Gaming Headset", 1800.0, 12);

        OrderDetail detail3 = new OrderDetail(1, TaxStatus.TAXABLE, keyboard);
        OrderDetail detail4 = new OrderDetail(2, TaxStatus.TAXABLE, headset);

        Order order2 = new Order(new Date(), OrderStatus.PROCESSING, customer2);
        order2.addOrderDetail(detail3);
        order2.addOrderDetail(detail4);

        Payment payment2 = new Check((float) order2.calcTotal(), "Lokeshkumar", "BANK12345");
        order2.setPayment(payment2);

        order2.printInvoice();
    }
}