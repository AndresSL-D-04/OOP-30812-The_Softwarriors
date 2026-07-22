/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class CreditAccountTest {
    
    public CreditAccountTest() {
    }

    /**
     * Test of getCustomerId method, of class CreditAccount.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        CreditAccount instance = new CreditAccount();
        int expResult = 0;
        int result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerId method, of class CreditAccount.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        int customerId = 0;
        CreditAccount instance = new CreditAccount();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class CreditAccount.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        CreditAccount instance = new CreditAccount();
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class CreditAccount.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        CreditAccount instance = new CreditAccount();
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreditLimit method, of class CreditAccount.
     */
    @Test
    public void testGetCreditLimit() {
        System.out.println("getCreditLimit");
        CreditAccount instance = new CreditAccount();
        double expResult = 0.0;
        double result = instance.getCreditLimit();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreditLimit method, of class CreditAccount.
     */
    @Test
    public void testSetCreditLimit() {
        System.out.println("setCreditLimit");
        double creditLimit = 0.0;
        CreditAccount instance = new CreditAccount();
        instance.setCreditLimit(creditLimit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDebt method, of class CreditAccount.
     */
    @Test
    public void testGetCurrentDebt() {
        System.out.println("getCurrentDebt");
        CreditAccount instance = new CreditAccount();
        double expResult = 0.0;
        double result = instance.getCurrentDebt();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentDebt method, of class CreditAccount.
     */
    @Test
    public void testSetCurrentDebt() {
        System.out.println("setCurrentDebt");
        double currentDebt = 0.0;
        CreditAccount instance = new CreditAccount();
        instance.setCurrentDebt(currentDebt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactions method, of class CreditAccount.
     */
    @Test
    public void testGetTransactions() {
        System.out.println("getTransactions");
        CreditAccount instance = new CreditAccount();
        List<Transaction> expResult = null;
        List<Transaction> result = instance.getTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransactions method, of class CreditAccount.
     */
    @Test
    public void testSetTransactions() {
        System.out.println("setTransactions");
        List<Transaction> transactions = null;
        CreditAccount instance = new CreditAccount();
        instance.setTransactions(transactions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBlocked method, of class CreditAccount.
     */
    @Test
    public void testIsBlocked() {
        System.out.println("isBlocked");
        CreditAccount instance = new CreditAccount();
        boolean expResult = false;
        boolean result = instance.isBlocked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlocked method, of class CreditAccount.
     */
    @Test
    public void testSetBlocked() {
        System.out.println("setBlocked");
        boolean blocked = false;
        CreditAccount instance = new CreditAccount();
        instance.setBlocked(blocked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTransaction method, of class CreditAccount.
     */
    @Test
    public void testAddTransaction() {
        System.out.println("addTransaction");
        Transaction transaction = null;
        CreditAccount instance = new CreditAccount();
        instance.addTransaction(transaction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CreditAccount.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CreditAccount instance = new CreditAccount();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
