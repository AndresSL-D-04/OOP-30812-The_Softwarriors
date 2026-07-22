/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.InvoiceItem;
import ec.edu.espe.safestore.model.Supplier;
import ec.edu.espe.safestore.model.SupplierInvoice;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class SupplierControllerTest {
    
    public SupplierControllerTest() {
    }

    /**
     * Test of addSupplier method, of class SupplierController.
     */
    @Test
    public void testAddSupplier() {
        System.out.println("addSupplier");
        Supplier supplier = null;
        SupplierController instance = new SupplierController();
        boolean expResult = false;
        boolean result = instance.addSupplier(supplier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSupplierById method, of class SupplierController.
     */
    @Test
    public void testFindSupplierById() {
        System.out.println("findSupplierById");
        int id = 0;
        SupplierController instance = new SupplierController();
        Supplier expResult = null;
        Supplier result = instance.findSupplierById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSuppliers method, of class SupplierController.
     */
    @Test
    public void testGetAllSuppliers() {
        System.out.println("getAllSuppliers");
        SupplierController instance = new SupplierController();
        List<Supplier> expResult = null;
        List<Supplier> result = instance.getAllSuppliers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSupplier method, of class SupplierController.
     */
    @Test
    public void testUpdateSupplier() {
        System.out.println("updateSupplier");
        Supplier supplier = null;
        SupplierController instance = new SupplierController();
        boolean expResult = false;
        boolean result = instance.updateSupplier(supplier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSupplier method, of class SupplierController.
     */
    @Test
    public void testDeleteSupplier() {
        System.out.println("deleteSupplier");
        int id = 0;
        SupplierController instance = new SupplierController();
        boolean expResult = false;
        boolean result = instance.deleteSupplier(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInvoice method, of class SupplierController.
     */
    @Test
    public void testAddInvoice() {
        System.out.println("addInvoice");
        SupplierInvoice invoice = null;
        SupplierController instance = new SupplierController();
        boolean expResult = false;
        boolean result = instance.addInvoice(invoice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPendingInvoices method, of class SupplierController.
     */
    @Test
    public void testGetPendingInvoices() {
        System.out.println("getPendingInvoices");
        SupplierController instance = new SupplierController();
        List<SupplierInvoice> expResult = null;
        List<SupplierInvoice> result = instance.getPendingInvoices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllInvoices method, of class SupplierController.
     */
    @Test
    public void testGetAllInvoices() {
        System.out.println("getAllInvoices");
        SupplierController instance = new SupplierController();
        List<SupplierInvoice> expResult = null;
        List<SupplierInvoice> result = instance.getAllInvoices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payInvoice method, of class SupplierController.
     */
    @Test
    public void testPayInvoice() {
        System.out.println("payInvoice");
        int invoiceId = 0;
        SupplierController instance = new SupplierController();
        boolean expResult = false;
        boolean result = instance.payInvoice(invoiceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoiceItems method, of class SupplierController.
     */
    @Test
    public void testGetInvoiceItems() {
        System.out.println("getInvoiceItems");
        int invoiceId = 0;
        SupplierController instance = new SupplierController();
        List<InvoiceItem> expResult = null;
        List<InvoiceItem> result = instance.getInvoiceItems(invoiceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
