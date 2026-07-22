/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import java.util.List;
import org.bson.Document;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class CashControllerTest {
    
    public CashControllerTest() {
    }

    /**
     * Test of openCash method, of class CashController.
     */
    @Test
    public void testOpenCash() {
        System.out.println("openCash");
        double initialAmount = 0.0;
        CashController instance = new CashController();
        boolean expResult = false;
        boolean result = instance.openCash(initialAmount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeCash method, of class CashController.
     */
    @Test
    public void testCloseCash() {
        System.out.println("closeCash");
        double physicalCount = 0.0;
        CashController instance = new CashController();
        boolean expResult = false;
        boolean result = instance.closeCash(physicalCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDifference method, of class CashController.
     */
    @Test
    public void testCalculateDifference() {
        System.out.println("calculateDifference");
        double physicalCount = 0.0;
        CashController instance = new CashController();
        double expResult = 0.0;
        double result = instance.calculateDifference(physicalCount);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addIncome method, of class CashController.
     */
    @Test
    public void testAddIncome() {
        System.out.println("addIncome");
        double amount = 0.0;
        String description = "";
        CashController instance = new CashController();
        boolean expResult = false;
        boolean result = instance.addIncome(amount, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addExpense method, of class CashController.
     */
    @Test
    public void testAddExpense() {
        System.out.println("addExpense");
        double amount = 0.0;
        String description = "";
        CashController instance = new CashController();
        boolean expResult = false;
        boolean result = instance.addExpense(amount, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentBalance method, of class CashController.
     */
    @Test
    public void testGetCurrentBalance() {
        System.out.println("getCurrentBalance");
        CashController instance = new CashController();
        double expResult = 0.0;
        double result = instance.getCurrentBalance();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOpen method, of class CashController.
     */
    @Test
    public void testIsOpen() {
        System.out.println("isOpen");
        CashController instance = new CashController();
        boolean expResult = false;
        boolean result = instance.isOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSessions method, of class CashController.
     */
    @Test
    public void testGetAllSessions() {
        System.out.println("getAllSessions");
        CashController instance = new CashController();
        List<Document> expResult = null;
        List<Document> result = instance.getAllSessions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
