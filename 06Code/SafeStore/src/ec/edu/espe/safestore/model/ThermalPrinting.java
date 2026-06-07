package ec.edu.espe.safestore.model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */


public class ThermalPrinting {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- THERMAL PRINTING ---");
        System.out.println("1. Connect printer");
        System.out.println("2. Print test");
        System.out.println("3. Generate ticket");
        System.out.println("4. Print ticket");
        System.out.println("5. Update information");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: connectPrinter(); break;
            case 2: printTest(); break;
            case 3: generateTicket(); break;
            case 4: printTicket(); break;
            case 5: updateInformation(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void connectPrinter() { System.out.println("Printer connected"); }
    private static void printTest() { System.out.println("Test printed"); }
    private static void generateTicket() { System.out.println("Ticket generated"); }
    private static void printTicket() { System.out.println("Ticket printed"); }
    private static void updateInformation() { System.out.println("Information updated"); }
}