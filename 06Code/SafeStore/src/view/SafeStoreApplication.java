/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import model.*;
import java.util.Scanner;

public class SafeStoreApplication {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SISTEMA SAFESTORE ===");
            System.out.println("1. Respaldos");
            System.out.println("2. Control de Caja");
            System.out.println("3. Combos");
            System.out.println("4. Creditos");
            System.out.println("5. Redondeo Festivo");
            System.out.println("6. Control de Vencimiento");
            System.out.println("7. Multiples Codigos");
            System.out.println("8. Reporte Baja Rotacion");
            System.out.println("9. Alertas de Stock");
            System.out.println("10. Impresion Termica");
            System.out.println("11. Interfaz Adaptable");
            System.out.println("12. Ventas por Peso");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            
            int opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1: BackupSystem.menu(sc); break;
                case 2: CashControl.menu(sc); break;
                case 3: ComboSystem.menu(sc); break;
                case 4: CreditManagement.menu(sc); break;
                case 5: HolidayRoundMode.menu(sc); break;
                case 6: ExpirationControl.menu(sc); break;
                case 7: ProductMultiCode.menu(sc); break;
                case 8: SlowMovingReport.menu(sc); break;
                case 9: StockMinAlert.menu(sc); break;
                case 10: ThermalPrinting.menu(sc); break;
                case 11: UIAdaptive.menu(sc); break;
                case 12: WeightSales.menu(sc); break;
                case 0: System.out.println("Hasta luego!"); return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
}
