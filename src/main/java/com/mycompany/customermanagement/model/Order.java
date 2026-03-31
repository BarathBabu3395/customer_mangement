package com.mycompany.customermanagement.model;

import com.mycompany.customermanagement.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private OrderStatus status;
    private Customer customer;
    private List<OrderDetail> orderDetails;
    private Payment payment;

    public Order(Date date, OrderStatus status, Customer customer) {
        if (date == null || status == null || customer == null) {
            throw new IllegalArgumentException("Order date, status, and customer cannot be null");
        }
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetail detail) {
        if (detail == null) {
            throw new IllegalArgumentException("Order detail cannot be null");
        }
        orderDetails.add(detail);
    }

    public void setPayment(Payment payment) {
        if (payment == null || !payment.authorized()) {
            throw new IllegalArgumentException("Invalid or unauthorized payment");
        }
        this.payment = payment;
    }

    public double calcSubTotal() {
        return orderDetails.stream()
                .mapToDouble(OrderDetail::calcSubTotal)
                .sum();
    }

    public double calcTax() {
        return orderDetails.stream()
                .mapToDouble(OrderDetail::calcTax)
                .sum();
    }

    public double calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public double calcTotalWeight() {
        return orderDetails.stream()
                .mapToDouble(OrderDetail::calcWeight)
                .sum();
    }

    public void printInvoice() {
        System.out.println("========== CUSTOMER MANAGEMENT INVOICE ==========");
        System.out.println("Customer : " + customer.getName());
        System.out.println("Address  : " + customer.getAddress());
        System.out.println("Date     : " + date);
        System.out.println("Status   : " + status);
        System.out.println("-----------------------------------------------");
        for (OrderDetail detail : orderDetails) {
            System.out.println("Item     : " + detail.getItem().getDescription());
            System.out.println("Qty      : " + detail.getQuantity());
            System.out.println("Subtotal : " + detail.calcSubTotal());
            System.out.println("Tax      : " + detail.calcTax());
            System.out.println("Weight   : " + detail.calcWeight());
            System.out.println("-----------------------------------------------");
        }
        System.out.println("Order Subtotal   : " + calcSubTotal());
        System.out.println("Order Tax        : " + calcTax());
        System.out.println("Order Total      : " + calcTotal());
        System.out.println("Total Weight     : " + calcTotalWeight());
        System.out.println("Payment Approved : " + (payment != null && payment.authorized()));
        System.out.println("===============================================");
    }
}