/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.model;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class BackupTest {
    
    public BackupTest() {
    }

    /**
     * Test of getBackupId method, of class Backup.
     */
    @Test
    public void testGetBackupId() {
        System.out.println("getBackupId");
        Backup instance = new Backup();
        int expResult = 0;
        int result = instance.getBackupId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBackupId method, of class Backup.
     */
    @Test
    public void testSetBackupId() {
        System.out.println("setBackupId");
        int backupId = 0;
        Backup instance = new Backup();
        instance.setBackupId(backupId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileName method, of class Backup.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        Backup instance = new Backup();
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFileName method, of class Backup.
     */
    @Test
    public void testSetFileName() {
        System.out.println("setFileName");
        String fileName = "";
        Backup instance = new Backup();
        instance.setFileName(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Backup.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Backup instance = new Backup();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Backup.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Backup instance = new Backup();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Backup.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Backup instance = new Backup();
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Backup.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        LocalDate date = null;
        Backup instance = new Backup();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Backup.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Backup instance = new Backup();
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class Backup.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        Backup expResult = null;
        Backup result = Backup.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBackups method, of class Backup.
     */
    @Test
    public void testGetAllBackups() {
        System.out.println("getAllBackups");
        List<Backup> expResult = null;
        List<Backup> result = Backup.getAllBackups();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStatus method, of class Backup.
     */
    @Test
    public void testUpdateStatus() {
        System.out.println("updateStatus");
        int backupId = 0;
        String newStatus = "";
        boolean expResult = false;
        boolean result = Backup.updateStatus(backupId, newStatus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Backup.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Backup instance = new Backup();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
