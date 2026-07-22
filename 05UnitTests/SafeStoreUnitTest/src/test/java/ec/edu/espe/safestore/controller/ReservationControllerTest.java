/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Reservation;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class ReservationControllerTest {
    
    public ReservationControllerTest() {
    }

    /**
     * Test of addReservation method, of class ReservationController.
     */
    @Test
    public void testAddReservation() {
        System.out.println("addReservation");
        Reservation reservation = null;
        ReservationController instance = new ReservationController();
        boolean expResult = false;
        boolean result = instance.addReservation(reservation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ReservationController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        ReservationController instance = new ReservationController();
        Reservation expResult = null;
        Reservation result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiveReservations method, of class ReservationController.
     */
    @Test
    public void testGetActiveReservations() {
        System.out.println("getActiveReservations");
        ReservationController instance = new ReservationController();
        List<Reservation> expResult = null;
        List<Reservation> result = instance.getActiveReservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllReservations method, of class ReservationController.
     */
    @Test
    public void testGetAllReservations() {
        System.out.println("getAllReservations");
        ReservationController instance = new ReservationController();
        List<Reservation> expResult = null;
        List<Reservation> result = instance.getAllReservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProductToReservation method, of class ReservationController.
     */
    @Test
    public void testAddProductToReservation() {
        System.out.println("addProductToReservation");
        int reservationId = 0;
        int productId = 0;
        int quantity = 0;
        ReservationController instance = new ReservationController();
        boolean expResult = false;
        boolean result = instance.addProductToReservation(reservationId, productId, quantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completeReservation method, of class ReservationController.
     */
    @Test
    public void testCompleteReservation() {
        System.out.println("completeReservation");
        int reservationId = 0;
        ReservationController instance = new ReservationController();
        boolean expResult = false;
        boolean result = instance.completeReservation(reservationId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelReservation method, of class ReservationController.
     */
    @Test
    public void testCancelReservation() {
        System.out.println("cancelReservation");
        int reservationId = 0;
        ReservationController instance = new ReservationController();
        boolean expResult = false;
        boolean result = instance.cancelReservation(reservationId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extendReservation method, of class ReservationController.
     */
    @Test
    public void testExtendReservation() {
        System.out.println("extendReservation");
        int reservationId = 0;
        int extraDays = 0;
        ReservationController instance = new ReservationController();
        boolean expResult = false;
        boolean result = instance.extendReservation(reservationId, extraDays);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
