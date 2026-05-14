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

public class CashControl {
    
    public static void menu(Scanner sc) {
        System.out.println("\nCASH CONTROL");
        System.out.println("1. Open cash register");
        System.out.println("2. Close cash register");
        System.out.println("3. Calculate total");
        System.out.println("4. Calculate difference");
        System.out.print("Option: ");
        
        int option = sc.nextInt();
        
        switch(option) {
            case 1: openCashRegister(); break;
            case 2: closeCashRegister(); break;
            case 3: calculateTotal(); break;
            case 4: calculateDifference(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void openCashRegister() { 
        System.out.println("Cash register opened"); 
    }
    
    private static void closeCashRegister() { 
        System.out.println("Cash register closed"); 
    }
    
    private static void calculateTotal() { 
        System.out.println("Total calculated"); 
    }
    
    private static void calculateDifference() { 
        System.out.println("Difference calculated"); 
    }
}