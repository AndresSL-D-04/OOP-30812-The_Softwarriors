package ec.edu.espe.safestore.model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */


public class SlowMovingReport {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- SLOW MOVING REPORT ---");
        System.out.println("1. Analyze products");
        System.out.println("2. Create report");
        System.out.println("3. Export to PDF");
        System.out.println("4. Recommend restock");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: analyzeProducts(); break;
            case 2: createReport(); break;
            case 3: exportToPDF(); break;
            case 4: recommendRestock(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void analyzeProducts() { System.out.println("Analyzing products"); }
    private static void createReport() { System.out.println("Report created"); }
    private static void exportToPDF() { System.out.println("Exported to PDF"); }
    private static void recommendRestock() { System.out.println("Recommendation generated"); }
}
