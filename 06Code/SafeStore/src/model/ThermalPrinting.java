/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import java.util.Scanner;

public class ThermalPrinting {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- IMPRESION TERMICA ---");
        System.out.println("1. Conectar impresora");
        System.out.println("2. Imprimir prueba");
        System.out.println("3. Generar ticket");
        System.out.println("4. Imprimir ticket");
        System.out.println("5. Actualizar informacion");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: conectarImpresora(); break;
            case 2: imprimirPrueba(); break;
            case 3: generarTicket(); break;
            case 4: imprimirTicket(); break;
            case 5: actualizarInfo(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void conectarImpresora() { System.out.println("Impresora conectada"); }
    private static void imprimirPrueba() { System.out.println("Prueba impresa"); }
    private static void generarTicket() { System.out.println("Ticket generado"); }
    private static void imprimirTicket() { System.out.println("Ticket impreso"); }
    private static void actualizarInfo() { System.out.println("Informacion actualizada"); }
}