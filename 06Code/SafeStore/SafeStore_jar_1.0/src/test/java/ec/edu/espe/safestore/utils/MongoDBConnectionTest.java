/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
public class MongoDBConnectionTest {
    
    public MongoDBConnectionTest() {
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
     * Test of connect method, of class MongoDBConnection.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        MongoDBConnection instance = new MongoDBConnection();
        boolean expResult = false;
        boolean result = instance.connect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatabase method, of class MongoDBConnection.
     */
    @Test
    public void testGetDatabase() {
        System.out.println("getDatabase");
        MongoDBConnection instance = new MongoDBConnection();
        MongoDatabase expResult = null;
        MongoDatabase result = instance.getDatabase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollection method, of class MongoDBConnection.
     */
    @Test
    public void testGetCollection() {
        System.out.println("getCollection");
        String collectionName = "";
        MongoDBConnection instance = new MongoDBConnection();
        MongoCollection<Document> expResult = null;
        MongoCollection<Document> result = instance.getCollection(collectionName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class MongoDBConnection.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        MongoDBConnection instance = new MongoDBConnection();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConnected method, of class MongoDBConnection.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        MongoDBConnection instance = new MongoDBConnection();
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
