/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.utils;

import ec.edu.espe.safestore.model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ronal
 */
public class ValidationUtilTest {
    
    public ValidationUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValidId method, of class ValidationUtil.
     */
    @Test
    public void testIsValidId() {
        System.out.println("isValidId");
        int id = 0;
        boolean expResult = false;
        boolean result = ValidationUtil.isValidId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidName method, of class ValidationUtil.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        String name = "";
        boolean expResult = false;
        boolean result = ValidationUtil.isValidName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidPrice method, of class ValidationUtil.
     */
    @Test
    public void testIsValidPrice() {
        System.out.println("isValidPrice");
        double price = 0.0;
        boolean expResult = false;
        boolean result = ValidationUtil.isValidPrice(price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidStock method, of class ValidationUtil.
     */
    @Test
    public void testIsValidStock() {
        System.out.println("isValidStock");
        int stock = 0;
        boolean expResult = false;
        boolean result = ValidationUtil.isValidStock(stock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidMinStock method, of class ValidationUtil.
     */
    @Test
    public void testIsValidMinStock() {
        System.out.println("isValidMinStock");
        int minStock = 0;
        boolean expResult = false;
        boolean result = ValidationUtil.isValidMinStock(minStock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidProduct method, of class ValidationUtil.
     */
    @Test
    public void testIsValidProduct() {
        System.out.println("isValidProduct");
        Product p = null;
        boolean expResult = false;
        boolean result = ValidationUtil.isValidProduct(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidPassword method, of class ValidationUtil.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        String password = "";
        boolean expResult = false;
        boolean result = ValidationUtil.isValidPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidUsername method, of class ValidationUtil.
     */
    @Test
    public void testIsValidUsername() {
        System.out.println("isValidUsername");
        String username = "";
        boolean expResult = false;
        boolean result = ValidationUtil.isValidUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidPhone method, of class ValidationUtil.
     */
    @Test
    public void testIsValidPhone() {
        System.out.println("isValidPhone");
        String phone = "";
        boolean expResult = false;
        boolean result = ValidationUtil.isValidPhone(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidEmail method, of class ValidationUtil.
     */
    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        String email = "";
        boolean expResult = false;
        boolean result = ValidationUtil.isValidEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidAmount method, of class ValidationUtil.
     */
    @Test
    public void testIsValidAmount() {
        System.out.println("isValidAmount");
        double amount = 0.0;
        boolean expResult = false;
        boolean result = ValidationUtil.isValidAmount(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
