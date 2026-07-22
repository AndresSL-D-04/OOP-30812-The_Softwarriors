/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.utils;

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
public class PasswordUtilTest {
    
    public PasswordUtilTest() {
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
     * Test of encryptPassword method, of class PasswordUtil.
     */
    @Test
    public void testEncryptPassword() {
        System.out.println("encryptPassword");
        String password = "";
        String expResult = "";
        String result = PasswordUtil.encryptPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class PasswordUtil.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "";
        String storedHash = "";
        boolean expResult = false;
        boolean result = PasswordUtil.checkPassword(password, storedHash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
