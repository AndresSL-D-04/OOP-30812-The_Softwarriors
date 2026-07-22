/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.utils;

import ec.edu.espe.safestore.controller.interfaces.IAuthController;
import ec.edu.espe.safestore.repository.interfaces.IUserRepository;
import ec.edu.espe.safestore.service.interfaces.IAuthService;
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
public class ServiceFactoryTest {
    
    public ServiceFactoryTest() {
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
     * Test of getDBConnection method, of class ServiceFactory.
     */
    @Test
    public void testGetDBConnection() {
        System.out.println("getDBConnection");
        MongoDBConnection expResult = null;
        MongoDBConnection result = ServiceFactory.getDBConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserRepository method, of class ServiceFactory.
     */
    @Test
    public void testGetUserRepository() {
        System.out.println("getUserRepository");
        IUserRepository expResult = null;
        IUserRepository result = ServiceFactory.getUserRepository();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthService method, of class ServiceFactory.
     */
    @Test
    public void testGetAuthService() {
        System.out.println("getAuthService");
        IAuthService expResult = null;
        IAuthService result = ServiceFactory.getAuthService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthController method, of class ServiceFactory.
     */
    @Test
    public void testGetAuthController() {
        System.out.println("getAuthController");
        IAuthController expResult = null;
        IAuthController result = ServiceFactory.getAuthController();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
