package model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class WeightSales {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- WEIGHT BASED SALES ---");
        System.out.println("1. Reduce weight");
        System.out.println("2. Calculate price");
        System.out.println("3. Convert to grams");
        System.out.println("4. Convert to pounds");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: reduceWeight(); break;
            case 2: calculatePrice(); break;
            case 3: convertToGrams(); break;
            case 4: convertToPounds(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void reduceWeight() { System.out.println("Weight reduced"); }
    private static void calculatePrice() { System.out.println("Price calculated"); }
    private static void convertToGrams() { System.out.println("Converted to grams"); }
    private static void convertToPounds() { System.out.println("Converted to pounds"); }
}