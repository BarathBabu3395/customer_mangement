package com.mycompany.devops_project;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private String status;
    private Customer customer;
    private List<OrderDetail> orderDetails;
    private Payment payment;

    public Order(Date date, String status, Customer customer) {
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetail detail) {
        orderDetails.add(detail);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double calcSubTotal() {
        double subtotal = 0;
        for (OrderDetail detail : orderDetails) {
            subtotal += detail.calcSubTotal();
        }
        return subtotal;
    }

    public double calcTax() {
        double tax = 0;
        for (OrderDetail detail : orderDetails) {
            tax += detail.calcTax();
        }
        return tax;
    }

    public double calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public double calcTotalWeight() {
        double totalWeight = 0;
        for (OrderDetail detail : orderDetails) {
            totalWeight += detail.calcWeight();
        }
        return totalWeight;
    }

    public void displayOrder() {
        System.out.println("----- ORDER DETAILS -----");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address : " + customer.getAddress());
        System.out.println("Status  : " + status);
        System.out.println("Subtotal: " + calcSubTotal());
        System.out.println("Tax     : " + calcTax());
        System.out.println("Total   : " + calcTotal());
        System.out.println("Weight  : " + calcTotalWeight());
        if (payment != null) {
            System.out.println("Payment Amount: " + payment.getAmount());
        }
    }
}