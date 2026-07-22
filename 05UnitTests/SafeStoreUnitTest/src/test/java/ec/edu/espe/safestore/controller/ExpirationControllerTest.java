/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Product;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class ExpirationControllerTest {
    
    public ExpirationControllerTest() {
    }

    /**
     * Test of setAlertDays method, of class ExpirationController.
     */
    @Test
    public void testSetAlertDays() {
        System.out.println("setAlertDays");
        int days = 0;
        ExpirationController instance = new ExpirationController();
        instance.setAlertDays(days);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlertDays method, of class ExpirationController.
     */
    @Test
    public void testGetAlertDays() {
        System.out.println("getAlertDays");
        ExpirationController instance = new ExpirationController();
        int expResult = 0;
        int result = instance.getAlertDays();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpiringSoonProducts method, of class ExpirationController.
     */
    @Test
    public void testGetExpiringSoonProducts() {
        System.out.println("getExpiringSoonProducts");
        ExpirationController instance = new ExpirationController();
        List<Product> expResult = null;
        List<Product> result = instance.getExpiringSoonProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpiredProducts method, of class ExpirationController.
     */
    @Test
    public void testGetExpiredProducts() {
        System.out.println("getExpiredProducts");
        ExpirationController instance = new ExpirationController();
        List<Product> expResult = null;
        List<Product> result = instance.getExpiredProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDiscount method, of class ExpirationController.
     */
    @Test
    public void testCalculateDiscount() {
        System.out.println("calculateDiscount");
        Product product = null;
        ExpirationController instance = new ExpirationController();
        double expResult = 0.0;
        double result = instance.calculateDiscount(product);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscountDescription method, of class ExpirationController.
     */
    @Test
    public void testGetDiscountDescription() {
        System.out.println("getDiscountDescription");
        Product product = null;
        ExpirationController instance = new ExpirationController();
        String expResult = "";
        String result = instance.getDiscountDescription(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
