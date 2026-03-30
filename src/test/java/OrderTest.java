package com.mycompany.devops_project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class OrderTest {

    @Test
    public void testCalcSubTotal() {
        Item item = new Item(2.0, "Book", 100, 10);
        OrderDetail detail = new OrderDetail(2, "TAXABLE", item);
        assertEquals(200, detail.calcSubTotal(), 0.01);
    }

    @Test
    public void testCalcTax() {
        Item item = new Item(1.0, "Pen", 50, 20);
        OrderDetail detail = new OrderDetail(2, "TAXABLE", item);
        assertEquals(10, detail.calcTax(), 0.01);
    }

    @Test
    public void testCalcTotal() {
        Customer customer = new Customer("Barath", "Vellore");
        Item item = new Item(1.0, "Notebook", 200, 5);
        OrderDetail detail = new OrderDetail(2, "TAXABLE", item);

        Order order = new Order(new Date(), "NEW", customer);
        order.addOrderDetail(detail);

        assertEquals(440, order.calcTotal(), 0.01);
    }

    @Test
    public void testCalcTotalWeight() {
        Customer customer = new Customer("Barath", "Vellore");
        Item item = new Item(3.0, "Printer", 5000, 2);
        OrderDetail detail = new OrderDetail(2, "TAXABLE", item);

        Order order = new Order(new Date(), "NEW", customer);
        order.addOrderDetail(detail);

        assertEquals(6.0, order.calcTotalWeight(), 0.01);
    }

    @Test
    public void testCreditAuthorization() {
        Credit credit = new Credit(1000, "Barath", "VISA", "12/28");
        assertTrue(credit.authorized());
    }
}