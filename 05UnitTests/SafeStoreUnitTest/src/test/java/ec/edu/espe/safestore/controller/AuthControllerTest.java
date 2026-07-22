/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.User;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class AuthControllerTest {
    
    public AuthControllerTest() {
    }

    /**
     * Test of authenticate method, of class AuthController.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        String username = "";
        String password = "";
        String role = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.authenticate(username, password, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class AuthController.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String username = "";
        String password = "";
        String role = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.addUser(username, password, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class AuthController.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "";
        String password = "";
        String confirmPassword = "";
        String email = "";
        String role = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.registerUser(username, password, confirmPassword, email, role);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateResetToken method, of class AuthController.
     */
    @Test
    public void testGenerateResetToken() {
        System.out.println("generateResetToken");
        String usernameOrEmail = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.generateResetToken(usernameOrEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidResetToken method, of class AuthController.
     */
    @Test
    public void testIsValidResetToken() {
        System.out.println("isValidResetToken");
        String token = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.isValidResetToken(token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPassword method, of class AuthController.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        String token = "";
        String newPassword = "";
        String confirmPassword = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.resetPassword(token, newPassword, confirmPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class AuthController.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String username = "";
        String oldPassword = "";
        String newPassword = "";
        String confirmPassword = "";
        AuthController instance = null;
        boolean expResult = false;
        boolean result = instance.changePassword(username, oldPassword, newPassword, confirmPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByUsername method, of class AuthController.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        String username = "";
        AuthController instance = null;
        User expResult = null;
        User result = instance.findByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmail method, of class AuthController.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        AuthController instance = null;
        User expResult = null;
        User result = instance.findByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class AuthController.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        AuthController instance = null;
        List<User> expResult = null;
        List<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
