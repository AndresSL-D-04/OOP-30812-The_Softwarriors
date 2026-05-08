
package model;
import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class StockMinAlert {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- ALERTAS DE STOCK ---");
        System.out.println("1. Configurar stock minimo");
        System.out.println("2. Configurar stock maximo");
        System.out.println("3. Generar alerta");
        System.out.println("4. Registrar movimiento");
        System.out.println("5. Ver stock actual");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: configurarMinimo(); break;
            case 2: configurarMaximo(); break;
            case 3: generarAlerta(); break;
            case 4: registrarMovimiento(); break;
            case 5: verStockActual(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void configurarMinimo() { System.out.println("Stock minimo configurado"); }
    private static void configurarMaximo() { System.out.println("Stock maximo configurado"); }
    private static void generarAlerta() { System.out.println("Alerta generada"); }
    private static void registrarMovimiento() { System.out.println("Movimiento registrado"); }
    private static void verStockActual() { System.out.println("Stock actual: 100 unidades"); }
    
}
