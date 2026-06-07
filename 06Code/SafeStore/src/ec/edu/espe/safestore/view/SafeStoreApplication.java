package ec.edu.espe.safestore.view;

import ec.edu.espe.safestore.model.ProductMultiCode;
import ec.edu.espe.safestore.model.WeightSales;
import ec.edu.espe.safestore.model.CreditManagement;
import ec.edu.espe.safestore.model.ThermalPrinting;
import ec.edu.espe.safestore.model.ComboSystem;
import ec.edu.espe.safestore.model.ExpirationControl;
import ec.edu.espe.safestore.model.CashControl;
import ec.edu.espe.safestore.model.HolidayRoundMode;
import ec.edu.espe.safestore.model.UIAdaptive;
import ec.edu.espe.safestore.model.BackupSystem;
import ec.edu.espe.safestore.model.SlowMovingReport;
import ec.edu.espe.safestore.model.StockMinAlert;
import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */


public class SafeStoreApplication {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SAFESTORE SYSTEM ===");
            System.out.println("1. Backups");
            System.out.println("2. Cash Control");
            System.out.println("3. Combos");
            System.out.println("4. Credits");
            System.out.println("5. Holiday Rounding");
            System.out.println("6. Expiration Control");
            System.out.println("7. Multiple Codes");
            System.out.println("8. Slow Moving Report");
            System.out.println("9. Stock Alerts");
            System.out.println("10. Thermal Printing");
            System.out.println("11. Adaptive UI");
            System.out.println("12. Weight Based Sales");
            System.out.println("13. Exit");
            System.out.print("Option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1: BackupSystem.menu(scanner); break;
                case 2: CashControl.menu(scanner); break;
                case 3: ComboSystem.menu(scanner); break;
                case 4: CreditManagement.menu(scanner); break;
                case 5: HolidayRoundMode.menu(scanner); break;
                case 6: ExpirationControl.menu(scanner); break;
                case 7: ProductMultiCode.menu(scanner); break;
                case 8: SlowMovingReport.menu(scanner); break;
                case 9: StockMinAlert.menu(scanner); break;
                case 10: ThermalPrinting.menu(scanner); break;
                case 11: UIAdaptive.menu(scanner); break;
                case 12: WeightSales.menu(scanner); break;
                case 0: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid option");
            }
        }
    }
}