/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.utils;

import ec.edu.espe.safestore.model.Combo;
import ec.edu.espe.safestore.model.CreditAccount;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.model.Reservation;
import ec.edu.espe.safestore.model.Sale;
import ec.edu.espe.safestore.model.Supplier;
import ec.edu.espe.safestore.model.SupplierInvoice;
import ec.edu.espe.safestore.model.User;
import org.bson.Document;
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
public class DocumentConverterTest {
    
    public DocumentConverterTest() {
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
     * Test of productToDoc method, of class DocumentConverter.
     */
    @Test
    public void testProductToDoc() {
        System.out.println("productToDoc");
        Product p = null;
        Document expResult = null;
        Document result = DocumentConverter.productToDoc(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToProduct method, of class DocumentConverter.
     */
    @Test
    public void testDocToProduct() {
        System.out.println("docToProduct");
        Document doc = null;
        Product expResult = null;
        Product result = DocumentConverter.docToProduct(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userToDoc method, of class DocumentConverter.
     */
    @Test
    public void testUserToDoc() {
        System.out.println("userToDoc");
        User u = null;
        Document expResult = null;
        Document result = DocumentConverter.userToDoc(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToUser method, of class DocumentConverter.
     */
    @Test
    public void testDocToUser() {
        System.out.println("docToUser");
        Document doc = null;
        User expResult = null;
        User result = DocumentConverter.docToUser(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saleToDoc method, of class DocumentConverter.
     */
    @Test
    public void testSaleToDoc() {
        System.out.println("saleToDoc");
        Sale s = null;
        Document expResult = null;
        Document result = DocumentConverter.saleToDoc(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToSale method, of class DocumentConverter.
     */
    @Test
    public void testDocToSale() {
        System.out.println("docToSale");
        Document doc = null;
        Sale expResult = null;
        Sale result = DocumentConverter.docToSale(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comboToDoc method, of class DocumentConverter.
     */
    @Test
    public void testComboToDoc() {
        System.out.println("comboToDoc");
        Combo c = null;
        Document expResult = null;
        Document result = DocumentConverter.comboToDoc(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToCombo method, of class DocumentConverter.
     */
    @Test
    public void testDocToCombo() {
        System.out.println("docToCombo");
        Document doc = null;
        Combo expResult = null;
        Combo result = DocumentConverter.docToCombo(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creditAccountToDoc method, of class DocumentConverter.
     */
    @Test
    public void testCreditAccountToDoc() {
        System.out.println("creditAccountToDoc");
        CreditAccount a = null;
        Document expResult = null;
        Document result = DocumentConverter.creditAccountToDoc(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToCreditAccount method, of class DocumentConverter.
     */
    @Test
    public void testDocToCreditAccount() {
        System.out.println("docToCreditAccount");
        Document doc = null;
        CreditAccount expResult = null;
        CreditAccount result = DocumentConverter.docToCreditAccount(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reservationToDoc method, of class DocumentConverter.
     */
    @Test
    public void testReservationToDoc() {
        System.out.println("reservationToDoc");
        Reservation r = null;
        Document expResult = null;
        Document result = DocumentConverter.reservationToDoc(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToReservation method, of class DocumentConverter.
     */
    @Test
    public void testDocToReservation() {
        System.out.println("docToReservation");
        Document doc = null;
        Reservation expResult = null;
        Reservation result = DocumentConverter.docToReservation(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supplierToDoc method, of class DocumentConverter.
     */
    @Test
    public void testSupplierToDoc() {
        System.out.println("supplierToDoc");
        Supplier s = null;
        Document expResult = null;
        Document result = DocumentConverter.supplierToDoc(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToSupplier method, of class DocumentConverter.
     */
    @Test
    public void testDocToSupplier() {
        System.out.println("docToSupplier");
        Document doc = null;
        Supplier expResult = null;
        Supplier result = DocumentConverter.docToSupplier(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invoiceToDoc method, of class DocumentConverter.
     */
    @Test
    public void testInvoiceToDoc() {
        System.out.println("invoiceToDoc");
        SupplierInvoice inv = null;
        Document expResult = null;
        Document result = DocumentConverter.invoiceToDoc(inv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docToInvoice method, of class DocumentConverter.
     */
    @Test
    public void testDocToInvoice() {
        System.out.println("docToInvoice");
        Document doc = null;
        SupplierInvoice expResult = null;
        SupplierInvoice result = DocumentConverter.docToInvoice(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
