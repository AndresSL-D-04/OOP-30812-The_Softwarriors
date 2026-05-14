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
public class ExpirationControl {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- EXPIRATION CONTROL ---");
        System.out.println("1. Generate alert");
        System.out.println("2. Send notification");
        System.out.println("3. Verify dates");
        System.out.print("Option: ");
        
        int option = sc.nextInt();
        
        switch(option) {
            case 1: generateAlert(); break;
            case 2: sendNotification(); break;
            case 3: verifyDates(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void generateAlert() { 
        System.out.println("Alert generated"); 
    }
    
    private static void sendNotification() { 
        System.out.println("Notification sent"); 
    }
    
    private static void verifyDates() { 
        System.out.println("Dates verified"); 
    }
}