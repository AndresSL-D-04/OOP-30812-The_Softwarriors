/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import java.util.Scanner;

public class ComboSystem {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- COMBOS ---");
        System.out.println("1. Create combo");
        System.out.println("2. Activate combo");
        System.out.println("3. Deactivate combo");
        System.out.println("4. Add product");
        System.out.print("Option: ");
        
        int option = sc.nextInt();
        
        switch(option) {
            case 1: createCombo(); break;
            case 2: activateCombo(); break;
            case 3: deactivateCombo(); break;
            case 4: addProduct(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void createCombo() { 
        System.out.println("Combo created"); 
    }
    
    private static void activateCombo() { 
        System.out.println("Combo activated"); 
    }
    
    private static void deactivateCombo() { 
        System.out.println("Combo deactivated"); 
    }
    
    private static void addProduct() { 
        System.out.println("Product added to combo"); 
    }
}