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
public class SaleItemTest {
    
    public SaleItemTest() {
    }

    /**
     * Test of getProductId method, of class SaleItem.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        SaleItem instance = new SaleItem();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class SaleItem.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 0;
        SaleItem instance = new SaleItem();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductName method, of class SaleItem.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        SaleItem instance = new SaleItem();
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductName method, of class SaleItem.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        SaleItem instance = new SaleItem();
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class SaleItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        SaleItem instance = new SaleItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class SaleItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        SaleItem instance = new SaleItem();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class SaleItem.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        SaleItem instance = new SaleItem();
        double expResult = 0.0;
        double result = instance.getUnitPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitPrice method, of class SaleItem.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        double unitPrice = 0.0;
        SaleItem instance = new SaleItem();
        instance.setUnitPrice(unitPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class SaleItem.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        SaleItem instance = new SaleItem();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPrice method, of class SaleItem.
     */
    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        double totalPrice = 0.0;
        SaleItem instance = new SaleItem();
        instance.setTotalPrice(totalPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SaleItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SaleItem instance = new SaleItem();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
