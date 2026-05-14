package model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class ProductMultiCode {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- MULTIPLE CODES ---");
        System.out.println("1. Add code");
        System.out.println("2. Remove code");
        System.out.println("3. Activate code");
        System.out.println("4. Search by code");
        System.out.println("5. Add product");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: addCode(); break;
            case 2: removeCode(); break;
            case 3: activateCode(); break;
            case 4: searchByCode(); break;
            case 5: addProduct(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void addCode() { System.out.println("Code added"); }
    private static void removeCode() { System.out.println("Code removed"); }
    private static void activateCode() { System.out.println("Code activated"); }
    private static void searchByCode() { System.out.println("Product found"); }
    private static void addProduct() { System.out.println("Product added"); }
}