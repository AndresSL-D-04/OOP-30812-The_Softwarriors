/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.model;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class SaleTest {
    
    public SaleTest() {
    }

    /**
     * Test of getSaleId method, of class Sale.
     */
    @Test
    public void testGetSaleId() {
        System.out.println("getSaleId");
        Sale instance = new Sale();
        int expResult = 0;
        int result = instance.getSaleId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleId method, of class Sale.
     */
    @Test
    public void testSetSaleId() {
        System.out.println("setSaleId");
        int saleId = 0;
        Sale instance = new Sale();
        instance.setSaleId(saleId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class Sale.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Sale instance = new Sale();
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class Sale.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Sale instance = new Sale();
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Sale.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Sale instance = new Sale();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Sale.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        LocalDateTime date = null;
        Sale instance = new Sale();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Sale.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Sale instance = new Sale();
        List<SaleItem> expResult = null;
        List<SaleItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class Sale.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        List<SaleItem> items = null;
        Sale instance = new Sale();
        instance.setItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class Sale.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        Sale instance = new Sale();
        double expResult = 0.0;
        double result = instance.getSubtotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubtotal method, of class Sale.
     */
    @Test
    public void testSetSubtotal() {
        System.out.println("setSubtotal");
        double subtotal = 0.0;
        Sale instance = new Sale();
        instance.setSubtotal(subtotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTax method, of class Sale.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        Sale instance = new Sale();
        double expResult = 0.0;
        double result = instance.getTax();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTax method, of class Sale.
     */
    @Test
    public void testSetTax() {
        System.out.println("setTax");
        double tax = 0.0;
        Sale instance = new Sale();
        instance.setTax(tax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Sale.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Sale instance = new Sale();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class Sale.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        Sale instance = new Sale();
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentMethod method, of class Sale.
     */
    @Test
    public void testGetPaymentMethod() {
        System.out.println("getPaymentMethod");
        Sale instance = new Sale();
        String expResult = "";
        String result = instance.getPaymentMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaymentMethod method, of class Sale.
     */
    @Test
    public void testSetPaymentMethod() {
        System.out.println("setPaymentMethod");
        String paymentMethod = "";
        Sale instance = new Sale();
        instance.setPaymentMethod(paymentMethod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaleType method, of class Sale.
     */
    @Test
    public void testGetSaleType() {
        System.out.println("getSaleType");
        Sale instance = new Sale();
        String expResult = "";
        String result = instance.getSaleType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleType method, of class Sale.
     */
    @Test
    public void testSetSaleType() {
        System.out.println("setSaleType");
        String saleType = "";
        Sale instance = new Sale();
        instance.setSaleType(saleType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        SaleItem item = null;
        Sale instance = new Sale();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sale.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sale instance = new Sale();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
