/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Combo;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class ComboControllerTest {
    
    public ComboControllerTest() {
    }

    /**
     * Test of addCombo method, of class ComboController.
     */
    @Test
    public void testAddCombo() {
        System.out.println("addCombo");
        Combo combo = null;
        ComboController instance = new ComboController();
        boolean expResult = false;
        boolean result = instance.addCombo(combo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCombo method, of class ComboController.
     */
    @Test
    public void testUpdateCombo() {
        System.out.println("updateCombo");
        Combo combo = null;
        ComboController instance = new ComboController();
        boolean expResult = false;
        boolean result = instance.updateCombo(combo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCombo method, of class ComboController.
     */
    @Test
    public void testDeleteCombo() {
        System.out.println("deleteCombo");
        int id = 0;
        ComboController instance = new ComboController();
        boolean expResult = false;
        boolean result = instance.deleteCombo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ComboController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        ComboController instance = new ComboController();
        Combo expResult = null;
        Combo result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCombos method, of class ComboController.
     */
    @Test
    public void testGetAllCombos() {
        System.out.println("getAllCombos");
        ComboController instance = new ComboController();
        List<Combo> expResult = null;
        List<Combo> result = instance.getAllCombos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProductToCombo method, of class ComboController.
     */
    @Test
    public void testAddProductToCombo() {
        System.out.println("addProductToCombo");
        int comboId = 0;
        int productId = 0;
        int quantity = 0;
        ComboController instance = new ComboController();
        boolean expResult = false;
        boolean result = instance.addProductToCombo(comboId, productId, quantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of activateCombo method, of class ComboController.
     */
    @Test
    public void testActivateCombo() {
        System.out.println("activateCombo");
        int id = 0;
        ComboController instance = new ComboController();
        boolean expResult = false;
        boolean result = instance.activateCombo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deactivateCombo method, of class ComboController.
     */
    @Test
    public void testDeactivateCombo() {
        System.out.println("deactivateCombo");
        int id = 0;
        ComboController instance = new ComboController();
        boolean expResult = false;
        boolean result = instance.deactivateCombo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
