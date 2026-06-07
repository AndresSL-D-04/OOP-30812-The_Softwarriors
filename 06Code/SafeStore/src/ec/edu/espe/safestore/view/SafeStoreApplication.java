
/**
 *
 * @author Adrian Vizcaino, The Softwarriors, @ESPE
 */

import model.*;
import java.util.Scanner;
public class SafeStoreApplication {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSAFESTORE SYSTEM");
            System.out.println("1. Respaldos");
            System.out.println("2. Control de Caja");
            System.out.println("3. Combos / Promociones");
            System.out.println("4. Gestion de Creditos");
            System.out.println("5. Control de Caducidad");
            System.out.println("6. Reporte de Productos Lentos");
            System.out.println("7. Alertas de Stock");
            System.out.println("8. Interfaz Adaptativa");
            System.out.println("9. Registro de Productos");
            System.out.println("10. Sistema de Ventas");
            System.out.println("11. Gestion de Proveedores");
            System.out.println("12. Reservas de Productos");
            System.out.println("13. Salir");
            System.out.print("Opcion: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    BackupSystem.menu(scanner);
                    break;
                case 2:
                    CashControl.menu(scanner);
                    break;
                case 3:
                    ComboSystem.menu(scanner);
                    break;
                case 4:
                    CreditManagement.menu(scanner);
                    break;
                case 5:
                    ExpirationControl.menu(scanner);
                    break;
                case 6:
                    SlowMovingReport.menu(scanner);
                    break;
                case 7:
                    StockMinAlert.menu(scanner);
                    break;
                case 8:
                    UIAdaptive.menu(scanner);
                    break;
                case 9:
                    ProductManagement.menu(scanner);
                    break;
                case 10:
                    SaleSystem.menu(scanner);
                    break;
                case 11:
                    SupplierManagement.menu(scanner);
                    break;
                case 12:
                    ReservationSystem.menu(scanner);
                    break;
                case 13:
                    System.out.println("Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}