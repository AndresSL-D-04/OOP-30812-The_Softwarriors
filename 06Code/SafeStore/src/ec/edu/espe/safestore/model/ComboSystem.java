package ec.edu.espe.safestore.model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class ComboSystem {
    
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- COMBOS ---");
        System.out.println("1. Create combo");
        System.out.println("2. Activate combo");
        System.out.println("3. Deactivate combo");
        System.out.println("4. Add product");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: createCombo(); break;
            case 2: activateCombo(); break;
            case 3: deactivateCombo(); break;
            case 4: addProduct(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void createCombo() { System.out.println("Combo created"); }
    private static void activateCombo() { System.out.println("Combo activated"); }
    private static void deactivateCombo() { System.out.println("Combo deactivated"); }
    private static void addProduct() { System.out.println("Product added to combo"); }
}