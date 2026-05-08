/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
import java.util.Scanner;

public class ComboSystem {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- COMBOS ---");
        System.out.println("1. Crear combo");
        System.out.println("2. Activar combo");
        System.out.println("3. Desactivar combo");
        System.out.println("4. Agregar producto");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: crearCombo(); break;
            case 2: activarCombo(); break;
            case 3: desactivarCombo(); break;
            case 4: agregarProducto(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void crearCombo() { System.out.println("Combo creado"); }
    private static void activarCombo() { System.out.println("Combo activado"); }
    private static void desactivarCombo() { System.out.println("Combo desactivado"); }
    private static void agregarProducto() { System.out.println("Producto agregado al combo"); }
}
