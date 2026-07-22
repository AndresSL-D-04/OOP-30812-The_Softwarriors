/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.model;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class SupplierInvoiceTest {
    
    public SupplierInvoiceTest() {
    }

    /**
     * Test of getInvoiceId method, of class SupplierInvoice.
     */
    @Test
    public void testGetInvoiceId() {
        System.out.println("getInvoiceId");
        SupplierInvoice instance = new SupplierInvoice();
        int expResult = 0;
        int result = instance.getInvoiceId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInvoiceId method, of class SupplierInvoice.
     */
    @Test
    public void testSetInvoiceId() {
        System.out.println("setInvoiceId");
        int invoiceId = 0;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setInvoiceId(invoiceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupplierId method, of class SupplierInvoice.
     */
    @Test
    public void testGetSupplierId() {
        System.out.println("getSupplierId");
        SupplierInvoice instance = new SupplierInvoice();
        int expResult = 0;
        int result = instance.getSupplierId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSupplierId method, of class SupplierInvoice.
     */
    @Test
    public void testSetSupplierId() {
        System.out.println("setSupplierId");
        int supplierId = 0;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setSupplierId(supplierId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoiceNumber method, of class SupplierInvoice.
     */
    @Test
    public void testGetInvoiceNumber() {
        System.out.println("getInvoiceNumber");
        SupplierInvoice instance = new SupplierInvoice();
        String expResult = "";
        String result = instance.getInvoiceNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInvoiceNumber method, of class SupplierInvoice.
     */
    @Test
    public void testSetInvoiceNumber() {
        System.out.println("setInvoiceNumber");
        String invoiceNumber = "";
        SupplierInvoice instance = new SupplierInvoice();
        instance.setInvoiceNumber(invoiceNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class SupplierInvoice.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        SupplierInvoice instance = new SupplierInvoice();
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class SupplierInvoice.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        LocalDate date = null;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDueDate method, of class SupplierInvoice.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        SupplierInvoice instance = new SupplierInvoice();
        LocalDate expResult = null;
        LocalDate result = instance.getDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDueDate method, of class SupplierInvoice.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        LocalDate dueDate = null;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setDueDate(dueDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class SupplierInvoice.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        SupplierInvoice instance = new SupplierInvoice();
        List<InvoiceItem> expResult = null;
        List<InvoiceItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class SupplierInvoice.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        List<InvoiceItem> items = null;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class SupplierInvoice.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        SupplierInvoice instance = new SupplierInvoice();
        double expResult = 0.0;
        double result = instance.getSubtotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubtotal method, of class SupplierInvoice.
     */
    @Test
    public void testSetSubtotal() {
        System.out.println("setSubtotal");
        double subtotal = 0.0;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setSubtotal(subtotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTax method, of class SupplierInvoice.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        SupplierInvoice instance = new SupplierInvoice();
        double expResult = 0.0;
        double result = instance.getTax();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTax method, of class SupplierInvoice.
     */
    @Test
    public void testSetTax() {
        System.out.println("setTax");
        double tax = 0.0;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setTax(tax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class SupplierInvoice.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        SupplierInvoice instance = new SupplierInvoice();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal method, of class SupplierInvoice.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        double total = 0.0;
        SupplierInvoice instance = new SupplierInvoice();
        instance.setTotal(total);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class SupplierInvoice.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        SupplierInvoice instance = new SupplierInvoice();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class SupplierInvoice.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        SupplierInvoice instance = new SupplierInvoice();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class SupplierInvoice.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        InvoiceItem item = null;
        SupplierInvoice instance = new SupplierInvoice();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOverdue method, of class SupplierInvoice.
     */
    @Test
    public void testIsOverdue() {
        System.out.println("isOverdue");
        SupplierInvoice instance = new SupplierInvoice();
        boolean expResult = false;
        boolean result = instance.isOverdue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SupplierInvoice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SupplierInvoice instance = new SupplierInvoice();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
