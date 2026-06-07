package ec.edu.espe.safestore.model;

import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class CreditManagement {
    
    public static void menu(Scanner scanner) {
        System.out.println("\n--- CREDITS ---");
        System.out.println("1. Add debt");
        System.out.println("2. Make payment");
        System.out.println("3. Check limit");
        System.out.println("4. Block account");
        System.out.println("5. Record payment");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: addDebt(); break;
            case 2: makePayment(); break;
            case 3: checkLimit(); break;
            case 4: blockAccount(); break;
            case 5: recordPayment(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void addDebt() { System.out.println("Debt added"); }
    private static void makePayment() { System.out.println("Payment made"); }
    private static void checkLimit() { System.out.println("Limit checked"); }
    private static void blockAccount() { System.out.println("Account blocked"); }
    private static void recordPayment() { System.out.println("Payment recorded"); }
}