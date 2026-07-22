/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Product;
import java.util.List;
import org.bson.Document;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class StockControllerTest {
    
    public StockControllerTest() {
    }

    /**
     * Test of getLowStockProducts method, of class StockController.
     */
    @Test
    public void testGetLowStockProducts() {
        System.out.println("getLowStockProducts");
        StockController instance = new StockController();
        List<Product> expResult = null;
        List<Product> result = instance.getLowStockProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCriticalStockProducts method, of class StockController.
     */
    @Test
    public void testGetCriticalStockProducts() {
        System.out.println("getCriticalStockProducts");
        StockController instance = new StockController();
        List<Product> expResult = null;
        List<Product> result = instance.getCriticalStockProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStock method, of class StockController.
     */
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock");
        int productId = 0;
        int newStock = 0;
        StockController instance = new StockController();
        boolean expResult = false;
        boolean result = instance.updateStock(productId, newStock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMinStock method, of class StockController.
     */
    @Test
    public void testUpdateMinStock() {
        System.out.println("updateMinStock");
        int productId = 0;
        int newMinStock = 0;
        StockController instance = new StockController();
        boolean expResult = false;
        boolean result = instance.updateMinStock(productId, newMinStock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateSuggestedOrder method, of class StockController.
     */
    @Test
    public void testCalculateSuggestedOrder() {
        System.out.println("calculateSuggestedOrder");
        Product product = null;
        StockController instance = new StockController();
        int expResult = 0;
        int result = instance.calculateSuggestedOrder(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateOrderList method, of class StockController.
     */
    @Test
    public void testGenerateOrderList() {
        System.out.println("generateOrderList");
        StockController instance = new StockController();
        List<String> expResult = null;
        List<String> result = instance.generateOrderList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockHistory method, of class StockController.
     */
    @Test
    public void testGetStockHistory() {
        System.out.println("getStockHistory");
        int productId = 0;
        StockController instance = new StockController();
        List<Document> expResult = null;
        List<Document> result = instance.getStockHistory(productId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
