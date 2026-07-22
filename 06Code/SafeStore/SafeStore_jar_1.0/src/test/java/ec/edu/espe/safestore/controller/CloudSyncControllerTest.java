/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class CloudSyncControllerTest {
    
    public CloudSyncControllerTest() {
    }

    /**
     * Test of connect method, of class CloudSyncController.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        CloudSyncController instance = new CloudSyncController();
        boolean expResult = false;
        boolean result = instance.connect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disconnect method, of class CloudSyncController.
     */
    @Test
    public void testDisconnect() {
        System.out.println("disconnect");
        CloudSyncController instance = new CloudSyncController();
        instance.disconnect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConnected method, of class CloudSyncController.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        CloudSyncController instance = new CloudSyncController();
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadProducts method, of class CloudSyncController.
     */
    @Test
    public void testUploadProducts() {
        System.out.println("uploadProducts");
        CloudSyncController instance = new CloudSyncController();
        instance.uploadProducts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of downloadProducts method, of class CloudSyncController.
     */
    @Test
    public void testDownloadProducts() {
        System.out.println("downloadProducts");
        CloudSyncController instance = new CloudSyncController();
        instance.downloadProducts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadAll method, of class CloudSyncController.
     */
    @Test
    public void testUploadAll() {
        System.out.println("uploadAll");
        CloudSyncController instance = new CloudSyncController();
        instance.uploadAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of downloadAll method, of class CloudSyncController.
     */
    @Test
    public void testDownloadAll() {
        System.out.println("downloadAll");
        CloudSyncController instance = new CloudSyncController();
        instance.downloadAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
