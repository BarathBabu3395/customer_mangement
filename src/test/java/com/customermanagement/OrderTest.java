package com.customermanagement;

import com.mycompany.customermanagement.enums.OrderStatus;
import com.mycompany.customermanagement.enums.TaxStatus;
import com.mycompany.customermanagement.model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void testCalcSubTotal() {
        Item item = new Item(1.5, "Book", 500, 10);
        OrderDetail detail = new OrderDetail(2, TaxStatus.TAXABLE, item);
        assertEquals(1000.0, detail.calcSubTotal(), 0.01);
    }

    @Test
    void testCalcTax() {
        Item item = new Item(1.0, "Pen", 100, 20);
        OrderDetail detail = new OrderDetail(2, TaxStatus.TAXABLE, item);
        assertEquals(20.0, detail.calcTax(), 0.01);
    }

    @Test
    void testCalcTotal() {
        Customer customer = new Customer("Barath", "Vellore");
        Item item = new Item(2.0, "Keyboard", 1000, 5);
        OrderDetail detail = new OrderDetail(1, TaxStatus.TAXABLE, item);

        Order order = new Order(new Date(), OrderStatus.NEW, customer);
        order.addOrderDetail(detail);

        assertEquals(1100.0, order.calcTotal(), 0.01);
    }

    @Test
    void testCalcTotalWeight() {
        Customer customer = new Customer("Barath", "Vellore");
        Item item = new Item(3.0, "Monitor", 7000, 5);
        OrderDetail detail = new OrderDetail(2, TaxStatus.NON_TAXABLE, item);

        Order order = new Order(new Date(), OrderStatus.NEW, customer);
        order.addOrderDetail(detail);

        assertEquals(6.0, order.calcTotalWeight(), 0.01);
    }

    @Test
    void testCreditAuthorization() {
        Credit credit = new Credit(2500, "Barath", "VISA", "12/28");
        assertTrue(credit.authorized());
    }
}