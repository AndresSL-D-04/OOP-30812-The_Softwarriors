package model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class ExpirationControl {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- EXPIRATION CONTROL ---");
        System.out.println("1. Generate alert");
        System.out.println("2. Send notification");
        System.out.println("3. Check dates");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: generateAlert(); break;
            case 2: sendNotification(); break;
            case 3: checkDates(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void generateAlert() { System.out.println("Alert generated"); }
    private static void sendNotification() { System.out.println("Notification sent"); }
    private static void checkDates() { System.out.println("Dates checked"); }
}
