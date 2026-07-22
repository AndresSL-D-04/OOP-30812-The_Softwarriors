/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class InvoiceItemTest {
    
    public InvoiceItemTest() {
    }

    /**
     * Test of getProductId method, of class InvoiceItem.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        InvoiceItem instance = new InvoiceItem();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class InvoiceItem.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 0;
        InvoiceItem instance = new InvoiceItem();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductName method, of class InvoiceItem.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        InvoiceItem instance = new InvoiceItem();
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductName method, of class InvoiceItem.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        InvoiceItem instance = new InvoiceItem();
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class InvoiceItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        InvoiceItem instance = new InvoiceItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class InvoiceItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        InvoiceItem instance = new InvoiceItem();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitCost method, of class InvoiceItem.
     */
    @Test
    public void testGetUnitCost() {
        System.out.println("getUnitCost");
        InvoiceItem instance = new InvoiceItem();
        double expResult = 0.0;
        double result = instance.getUnitCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitCost method, of class InvoiceItem.
     */
    @Test
    public void testSetUnitCost() {
        System.out.println("setUnitCost");
        double unitCost = 0.0;
        InvoiceItem instance = new InvoiceItem();
        instance.setUnitCost(unitCost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class InvoiceItem.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        InvoiceItem instance = new InvoiceItem();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPrice method, of class InvoiceItem.
     */
    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        double totalPrice = 0.0;
        InvoiceItem instance = new InvoiceItem();
        instance.setTotalPrice(totalPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class InvoiceItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        InvoiceItem instance = new InvoiceItem();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
