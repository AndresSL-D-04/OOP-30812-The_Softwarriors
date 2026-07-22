/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.model;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class ReservationTest {
    
    public ReservationTest() {
    }

    /**
     * Test of getReservationId method, of class Reservation.
     */
    @Test
    public void testGetReservationId() {
        System.out.println("getReservationId");
        Reservation instance = new Reservation();
        int expResult = 0;
        int result = instance.getReservationId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReservationId method, of class Reservation.
     */
    @Test
    public void testSetReservationId() {
        System.out.println("setReservationId");
        int reservationId = 0;
        Reservation instance = new Reservation();
        instance.setReservationId(reservationId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerId method, of class Reservation.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Reservation instance = new Reservation();
        int expResult = 0;
        int result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerId method, of class Reservation.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        int customerId = 0;
        Reservation instance = new Reservation();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class Reservation.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class Reservation.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Reservation instance = new Reservation();
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerPhone method, of class Reservation.
     */
    @Test
    public void testGetCustomerPhone() {
        System.out.println("getCustomerPhone");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getCustomerPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerPhone method, of class Reservation.
     */
    @Test
    public void testSetCustomerPhone() {
        System.out.println("setCustomerPhone");
        String customerPhone = "";
        Reservation instance = new Reservation();
        instance.setCustomerPhone(customerPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Reservation.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Reservation instance = new Reservation();
        List<ReservationItem> expResult = null;
        List<ReservationItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class Reservation.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        List<ReservationItem> items = null;
        Reservation instance = new Reservation();
        instance.setItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReservationDate method, of class Reservation.
     */
    @Test
    public void testGetReservationDate() {
        System.out.println("getReservationDate");
        Reservation instance = new Reservation();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getReservationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReservationDate method, of class Reservation.
     */
    @Test
    public void testSetReservationDate() {
        System.out.println("setReservationDate");
        LocalDateTime reservationDate = null;
        Reservation instance = new Reservation();
        instance.setReservationDate(reservationDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpiryDate method, of class Reservation.
     */
    @Test
    public void testGetExpiryDate() {
        System.out.println("getExpiryDate");
        Reservation instance = new Reservation();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getExpiryDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpiryDate method, of class Reservation.
     */
    @Test
    public void testSetExpiryDate() {
        System.out.println("setExpiryDate");
        LocalDateTime expiryDate = null;
        Reservation instance = new Reservation();
        instance.setExpiryDate(expiryDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Reservation.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Reservation.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Reservation instance = new Reservation();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotes method, of class Reservation.
     */
    @Test
    public void testGetNotes() {
        System.out.println("getNotes");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotes method, of class Reservation.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String notes = "";
        Reservation instance = new Reservation();
        instance.setNotes(notes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Reservation.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ReservationItem item = null;
        Reservation instance = new Reservation();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalValue method, of class Reservation.
     */
    @Test
    public void testGetTotalValue() {
        System.out.println("getTotalValue");
        Reservation instance = new Reservation();
        double expResult = 0.0;
        double result = instance.getTotalValue();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExpired method, of class Reservation.
     */
    @Test
    public void testIsExpired() {
        System.out.println("isExpired");
        Reservation instance = new Reservation();
        boolean expResult = false;
        boolean result = instance.isExpired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Reservation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
