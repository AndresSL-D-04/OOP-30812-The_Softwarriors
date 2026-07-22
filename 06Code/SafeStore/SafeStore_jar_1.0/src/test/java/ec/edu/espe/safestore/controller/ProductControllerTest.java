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
public class ProductControllerTest {
    
    public ProductControllerTest() {
    }

    /**
     * Test of addProduct method, of class ProductController.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = null;
        ProductController instance = new ProductController();
        boolean expResult = false;
        boolean result = instance.addProduct(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduct method, of class ProductController.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        Product product = null;
        ProductController instance = new ProductController();
        boolean expResult = false;
        boolean result = instance.updateProduct(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class ProductController.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        int id = 0;
        ProductController instance = new ProductController();
        boolean expResult = false;
        boolean result = instance.deleteProduct(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ProductController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        ProductController instance = new ProductController();
        Product expResult = null;
        Product result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProducts method, of class ProductController.
     */
    @Test
    public void testGetAllProducts() {
        System.out.println("getAllProducts");
        ProductController instance = new ProductController();
        List<Product> expResult = null;
        List<Product> result = instance.getAllProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLowStockProducts method, of class ProductController.
     */
    @Test
    public void testGetLowStockProducts() {
        System.out.println("getLowStockProducts");
        ProductController instance = new ProductController();
        List<Product> expResult = null;
        List<Product> result = instance.getLowStockProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStock method, of class ProductController.
     */
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock");
        int id = 0;
        int newStock = 0;
        ProductController instance = new ProductController();
        boolean expResult = false;
        boolean result = instance.updateStock(id, newStock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
