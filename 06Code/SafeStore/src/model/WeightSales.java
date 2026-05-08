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

public class WeightSales {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- VENTAS POR PESO ---");
        System.out.println("1. Reducir peso");
        System.out.println("2. Calcular precio");
        System.out.println("3. Convertir a gramos");
        System.out.println("4. Convertir a libras");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: reducirPeso(); break;
            case 2: calcularPrecio(); break;
            case 3: convertirAGramos(); break;
            case 4: convertirALibras(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void reducirPeso() { System.out.println("Peso reducido"); }
    private static void calcularPrecio() { System.out.println("Precio calculado"); }
    private static void convertirAGramos() { System.out.println("Convertido a gramos"); }
    private static void convertirALibras() { System.out.println("Convertido a libras"); }
}