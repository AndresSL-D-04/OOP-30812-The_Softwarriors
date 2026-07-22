/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Sale;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class SaleControllerTest {
    
    public SaleControllerTest() {
    }

    /**
     * Test of startNewSale method, of class SaleController.
     */
    @Test
    public void testStartNewSale() {
        System.out.println("startNewSale");
        int saleId = 0;
        String customerName = "";
        String saleType = "";
        String paymentMethod = "";
        SaleController instance = new SaleController();
        instance.startNewSale(saleId, customerName, saleType, paymentMethod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProductToCurrentSale method, of class SaleController.
     */
    @Test
    public void testAddProductToCurrentSale() {
        System.out.println("addProductToCurrentSale");
        int productId = 0;
        int quantity = 0;
        SaleController instance = new SaleController();
        boolean expResult = false;
        boolean result = instance.addProductToCurrentSale(productId, quantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSale method, of class SaleController.
     */
    @Test
    public void testGetCurrentSale() {
        System.out.println("getCurrentSale");
        SaleController instance = new SaleController();
        Sale expResult = null;
        Sale result = instance.getCurrentSale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizeSale method, of class SaleController.
     */
    @Test
    public void testFinalizeSale() {
        System.out.println("finalizeSale");
        SaleController instance = new SaleController();
        boolean expResult = false;
        boolean result = instance.finalizeSale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of holdCurrentSale method, of class SaleController.
     */
    @Test
    public void testHoldCurrentSale() {
        System.out.println("holdCurrentSale");
        SaleController instance = new SaleController();
        instance.holdCurrentSale();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resumeHoldSale method, of class SaleController.
     */
    @Test
    public void testResumeHoldSale() {
        System.out.println("resumeHoldSale");
        SaleController instance = new SaleController();
        instance.resumeHoldSale();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSales method, of class SaleController.
     */
    @Test
    public void testGetAllSales() {
        System.out.println("getAllSales");
        SaleController instance = new SaleController();
        List<Sale> expResult = null;
        List<Sale> result = instance.getAllSales();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSaleById method, of class SaleController.
     */
    @Test
    public void testFindSaleById() {
        System.out.println("findSaleById");
        int id = 0;
        SaleController instance = new SaleController();
        Sale expResult = null;
        Sale result = instance.findSaleById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
