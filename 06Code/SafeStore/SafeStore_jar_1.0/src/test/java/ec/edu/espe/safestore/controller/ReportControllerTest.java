/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Product;
import java.util.List;
import org.bson.Document;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class ReportControllerTest {
    
    public ReportControllerTest() {
    }

    /**
     * Test of getSlowMovingProducts method, of class ReportController.
     */
    @Test
    public void testGetSlowMovingProducts() {
        System.out.println("getSlowMovingProducts");
        ReportController instance = new ReportController();
        List<Product> expResult = null;
        List<Product> result = instance.getSlowMovingProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTurnoverRate method, of class ReportController.
     */
    @Test
    public void testCalculateTurnoverRate() {
        System.out.println("calculateTurnoverRate");
        Product product = null;
        ReportController instance = new ReportController();
        double expResult = 0.0;
        double result = instance.calculateTurnoverRate(product);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecommendation method, of class ReportController.
     */
    @Test
    public void testGetRecommendation() {
        System.out.println("getRecommendation");
        Product product = null;
        ReportController instance = new ReportController();
        String expResult = "";
        String result = instance.getRecommendation(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateReport method, of class ReportController.
     */
    @Test
    public void testGenerateReport() {
        System.out.println("generateReport");
        ReportController instance = new ReportController();
        String expResult = "";
        String result = instance.generateReport();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllReports method, of class ReportController.
     */
    @Test
    public void testGetAllReports() {
        System.out.println("getAllReports");
        ReportController instance = new ReportController();
        List<Document> expResult = null;
        List<Document> result = instance.getAllReports();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReportById method, of class ReportController.
     */
    @Test
    public void testGetReportById() {
        System.out.println("getReportById");
        int reportId = 0;
        ReportController instance = new ReportController();
        Document expResult = null;
        Document result = instance.getReportById(reportId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
