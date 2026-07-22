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
public class ReservationItemTest {
    
    public ReservationItemTest() {
    }

    /**
     * Test of getProductId method, of class ReservationItem.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        ReservationItem instance = new ReservationItem();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class ReservationItem.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 0;
        ReservationItem instance = new ReservationItem();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductName method, of class ReservationItem.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        ReservationItem instance = new ReservationItem();
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductName method, of class ReservationItem.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        ReservationItem instance = new ReservationItem();
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class ReservationItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ReservationItem instance = new ReservationItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class ReservationItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        ReservationItem instance = new ReservationItem();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class ReservationItem.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        ReservationItem instance = new ReservationItem();
        double expResult = 0.0;
        double result = instance.getUnitPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitPrice method, of class ReservationItem.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        double unitPrice = 0.0;
        ReservationItem instance = new ReservationItem();
        instance.setUnitPrice(unitPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class ReservationItem.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        ReservationItem instance = new ReservationItem();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPrice method, of class ReservationItem.
     */
    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        double totalPrice = 0.0;
        ReservationItem instance = new ReservationItem();
        instance.setTotalPrice(totalPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ReservationItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ReservationItem instance = new ReservationItem();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
