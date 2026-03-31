package com.mycompany.customermanagement.model;

import java.util.Objects;

public class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Customer address cannot be empty");
        }
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', address='" + address + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
               Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}