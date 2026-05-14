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
public class HolidayRoundMode {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- HOLIDAY ROUNDING MODE ---");
        System.out.println("1. Activate holiday mode");
        System.out.println("2. Deactivate holiday mode");
        System.out.println("3. Configure rule");
        System.out.println("4. Apply rounding");
        System.out.println("5. Add holiday");
        System.out.println("6. View report");
        System.out.print("Option: ");
        
        int option = sc.nextInt();
        
        switch(option) {
            case 1: activateHolidayMode(); break;
            case 2: deactivateHolidayMode(); break;
            case 3: configureRule(); break;
            case 4: applyRounding(); break;
            case 5: addHoliday(); break;
            case 6: viewReport(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void activateHolidayMode() { 
        System.out.println("Holiday mode activated"); 
    }
    
    private static void deactivateHolidayMode() { 
        System.out.println("Holiday mode deactivated"); 
    }
    
    private static void configureRule() { 
        System.out.println("Rule configured"); 
    }
    
    private static void applyRounding() { 
        System.out.println("Rounding applied"); 
    }
    
    private static void addHoliday() { 
        System.out.println("Holiday added"); 
    }
    
    private static void viewReport() { 
        System.out.println("Report generated"); 
    }
}