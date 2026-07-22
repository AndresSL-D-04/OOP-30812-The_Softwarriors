/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.CreditAccount;
import ec.edu.espe.safestore.model.Transaction;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class CreditControllerTest {
    
    public CreditControllerTest() {
    }

    /**
     * Test of addAccount method, of class CreditController.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        CreditAccount account = null;
        CreditController instance = new CreditController();
        boolean expResult = false;
        boolean result = instance.addAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByCustomerId method, of class CreditController.
     */
    @Test
    public void testFindByCustomerId() {
        System.out.println("findByCustomerId");
        int customerId = 0;
        CreditController instance = new CreditController();
        CreditAccount expResult = null;
        CreditAccount result = instance.findByCustomerId(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAccounts method, of class CreditController.
     */
    @Test
    public void testGetAllAccounts() {
        System.out.println("getAllAccounts");
        CreditController instance = new CreditController();
        List<CreditAccount> expResult = null;
        List<CreditAccount> result = instance.getAllAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDebt method, of class CreditController.
     */
    @Test
    public void testAddDebt() {
        System.out.println("addDebt");
        int customerId = 0;
        double amount = 0.0;
        String description = "";
        CreditController instance = new CreditController();
        boolean expResult = false;
        boolean result = instance.addDebt(customerId, amount, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makePayment method, of class CreditController.
     */
    @Test
    public void testMakePayment() {
        System.out.println("makePayment");
        int customerId = 0;
        double amount = 0.0;
        String description = "";
        CreditController instance = new CreditController();
        boolean expResult = false;
        boolean result = instance.makePayment(customerId, amount, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blockAccount method, of class CreditController.
     */
    @Test
    public void testBlockAccount() {
        System.out.println("blockAccount");
        int customerId = 0;
        CreditController instance = new CreditController();
        boolean expResult = false;
        boolean result = instance.blockAccount(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unblockAccount method, of class CreditController.
     */
    @Test
    public void testUnblockAccount() {
        System.out.println("unblockAccount");
        int customerId = 0;
        CreditController instance = new CreditController();
        boolean expResult = false;
        boolean result = instance.unblockAccount(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactions method, of class CreditController.
     */
    @Test
    public void testGetTransactions() {
        System.out.println("getTransactions");
        int customerId = 0;
        CreditController instance = new CreditController();
        List<Transaction> expResult = null;
        List<Transaction> result = instance.getTransactions(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
