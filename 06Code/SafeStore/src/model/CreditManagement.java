/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Ronald Tipan, The Softwarriors, @ESPE
 */
public class CreditManagement {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- CREDITS ---");
        System.out.println("1. Add debt");
        System.out.println("2. Make payment");
        System.out.println("3. Verify limit");
        System.out.println("4. Block account");
        System.out.println("5. Register payment");
        System.out.print("Option: ");
        
        int option = sc.nextInt();
        
        switch(option) {
            case 1: addDebt(); break;
            case 2: makePayment(); break;
            case 3: verifyLimit(); break;
            case 4: blockAccount(); break;
            case 5: registerPayment(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void addDebt() { 
        System.out.println("Debt added"); 
    }
    
    private static void makePayment() { 
        System.out.println("Payment made"); 
    }
    
    private static void verifyLimit() { 
        System.out.println("Limit verified"); 
    }
    
    private static void blockAccount() { 
        System.out.println("Account blocked"); 
    }
    
    private static void registerPayment() { 
        System.out.println("Payment registered"); 
    }
}