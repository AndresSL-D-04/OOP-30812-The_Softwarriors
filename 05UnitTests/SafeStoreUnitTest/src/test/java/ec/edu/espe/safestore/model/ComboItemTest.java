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
public class ComboItemTest {
    
    public ComboItemTest() {
    }

    /**
     * Test of getProductId method, of class ComboItem.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        ComboItem instance = new ComboItem();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductId method, of class ComboItem.
     */
    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int productId = 0;
        ComboItem instance = new ComboItem();
        instance.setProductId(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductName method, of class ComboItem.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        ComboItem instance = new ComboItem();
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductName method, of class ComboItem.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        ComboItem instance = new ComboItem();
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductPrice method, of class ComboItem.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        ComboItem instance = new ComboItem();
        double expResult = 0.0;
        double result = instance.getProductPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductPrice method, of class ComboItem.
     */
    @Test
    public void testSetProductPrice() {
        System.out.println("setProductPrice");
        double productPrice = 0.0;
        ComboItem instance = new ComboItem();
        instance.setProductPrice(productPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class ComboItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ComboItem instance = new ComboItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class ComboItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        ComboItem instance = new ComboItem();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ComboItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComboItem instance = new ComboItem();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
