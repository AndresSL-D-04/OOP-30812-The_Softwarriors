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
public class ProductTest {
    
    public ProductTest() {
    }

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Product.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Product instance = new Product();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Product instance = new Product();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWholesalePrice method, of class Product.
     */
    @Test
    public void testGetWholesalePrice() {
        System.out.println("getWholesalePrice");
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getWholesalePrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWholesalePrice method, of class Product.
     */
    @Test
    public void testSetWholesalePrice() {
        System.out.println("setWholesalePrice");
        double wholesalePrice = 0.0;
        Product instance = new Product();
        instance.setWholesalePrice(wholesalePrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRetailPrice method, of class Product.
     */
    @Test
    public void testGetRetailPrice() {
        System.out.println("getRetailPrice");
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getRetailPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRetailPrice method, of class Product.
     */
    @Test
    public void testSetRetailPrice() {
        System.out.println("setRetailPrice");
        double retailPrice = 0.0;
        Product instance = new Product();
        instance.setRetailPrice(retailPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStock method, of class Product.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStock method, of class Product.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 0;
        Product instance = new Product();
        instance.setStock(stock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinStock method, of class Product.
     */
    @Test
    public void testGetMinStock() {
        System.out.println("getMinStock");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getMinStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinStock method, of class Product.
     */
    @Test
    public void testSetMinStock() {
        System.out.println("setMinStock");
        int minStock = 0;
        Product instance = new Product();
        instance.setMinStock(minStock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpiryDate method, of class Product.
     */
    @Test
    public void testGetExpiryDate() {
        System.out.println("getExpiryDate");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getExpiryDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpiryDate method, of class Product.
     */
    @Test
    public void testSetExpiryDate() {
        System.out.println("setExpiryDate");
        String expiryDate = "";
        Product instance = new Product();
        instance.setExpiryDate(expiryDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriceByQuantity method, of class Product.
     */
    @Test
    public void testGetPriceByQuantity() {
        System.out.println("getPriceByQuantity");
        int quantity = 0;
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getPriceByQuantity(quantity);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
