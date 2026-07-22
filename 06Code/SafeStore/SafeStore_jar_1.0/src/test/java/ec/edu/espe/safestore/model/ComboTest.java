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
public class ComboTest {
    
    public ComboTest() {
    }

    /**
     * Test of getId method, of class Combo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Combo instance = new Combo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Combo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Combo instance = new Combo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Combo.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Combo instance = new Combo();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Combo.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Combo instance = new Combo();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Combo.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Combo instance = new Combo();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Combo.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Combo instance = new Combo();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Combo.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Combo instance = new Combo();
        List<ComboItem> expResult = null;
        List<ComboItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class Combo.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        List<ComboItem> items = null;
        Combo instance = new Combo();
        instance.setItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComboPrice method, of class Combo.
     */
    @Test
    public void testGetComboPrice() {
        System.out.println("getComboPrice");
        Combo instance = new Combo();
        double expResult = 0.0;
        double result = instance.getComboPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComboPrice method, of class Combo.
     */
    @Test
    public void testSetComboPrice() {
        System.out.println("setComboPrice");
        double comboPrice = 0.0;
        Combo instance = new Combo();
        instance.setComboPrice(comboPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Combo.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Combo instance = new Combo();
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActive method, of class Combo.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        Combo instance = new Combo();
        instance.setActive(active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Combo.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ComboItem item = null;
        Combo instance = new Combo();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateIndividualPrice method, of class Combo.
     */
    @Test
    public void testCalculateIndividualPrice() {
        System.out.println("calculateIndividualPrice");
        Combo instance = new Combo();
        double expResult = 0.0;
        double result = instance.calculateIndividualPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSavings method, of class Combo.
     */
    @Test
    public void testGetSavings() {
        System.out.println("getSavings");
        Combo instance = new Combo();
        double expResult = 0.0;
        double result = instance.getSavings();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Combo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Combo instance = new Combo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
