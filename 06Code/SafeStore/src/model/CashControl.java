package model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class CashControl {
    
    public static void menu(Scanner scanner) {
        System.out.println("\nCASH CONTROL");
        System.out.println("1. Open cash drawer");
        System.out.println("2. Close cash drawer");
        System.out.println("3. Calculate total");
        System.out.println("4. Calculate difference");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: openCashDrawer(); break;
            case 2: closeCashDrawer(); break;
            case 3: calculateTotal(); break;
            case 4: calculateDifference(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void openCashDrawer() { System.out.println("Cash drawer opened"); }
    private static void closeCashDrawer() { System.out.println("Cash drawer closed"); }
    private static void calculateTotal() { System.out.println("Total calculated"); }
    private static void calculateDifference() { System.out.println("Difference calculated"); }
}