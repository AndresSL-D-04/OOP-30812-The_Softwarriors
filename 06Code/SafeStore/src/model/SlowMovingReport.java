
package model;
import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class SlowMovingReport {
    public static void menu(Scanner sc) {
        System.out.println("\n--- BAJA ROTACION ---");
        System.out.println("1. Analizar productos");
        System.out.println("2. Crear reporte");
        System.out.println("3. Exportar a PDF");
        System.out.println("4. Recomendar reabastecimiento");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: analizarProductos(); break;
            case 2: crearReporte(); break;
            case 3: exportarPDF(); break;
            case 4: recomendarReabastecimiento(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void analizarProductos() { System.out.println("Analizando productos"); }
    private static void crearReporte() { System.out.println("Reporte creado"); }
    private static void exportarPDF() { System.out.println("Exportado a PDF"); }
    private static void recomendarReabastecimiento() { System.out.println("Recomendacion generada"); }
    
}
