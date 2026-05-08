
package model;
import java.util.Scanner;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class ProductMultiCode {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- MULTIPLES CODIGOS ---");
        System.out.println("1. Agregar codigo");
        System.out.println("2. Eliminar codigo");
        System.out.println("3. Activar codigo");
        System.out.println("4. Buscar por codigo");
        System.out.println("5. Agregar producto");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: agregarCodigo(); break;
            case 2: eliminarCodigo(); break;
            case 3: activarCodigo(); break;
            case 4: buscarPorCodigo(); break;
            case 5: agregarProducto(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void agregarCodigo() { System.out.println("Codigo agregado"); }
    private static void eliminarCodigo() { System.out.println("Codigo eliminado"); }
    private static void activarCodigo() { System.out.println("Codigo activado"); }
    private static void buscarPorCodigo() { System.out.println("Producto encontrado"); }
    private static void agregarProducto() { System.out.println("Producto agregado"); }
    
}
