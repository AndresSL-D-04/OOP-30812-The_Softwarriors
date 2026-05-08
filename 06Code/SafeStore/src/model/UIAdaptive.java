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

public class UIAdaptive {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- INTERFAZ ADAPTABLE ---");
        System.out.println("1. Aplicar tema");
        System.out.println("2. Alto contraste");
        System.out.println("3. Restaurar default");
        System.out.println("4. Asignar atajo");
        System.out.println("5. Listar atajos");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: aplicarTema(); break;
            case 2: altoContraste(); break;
            case 3: restaurarDefault(); break;
            case 4: asignarAtajo(); break;
            case 5: listarAtajos(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void aplicarTema() { System.out.println("Tema aplicado"); }
    private static void altoContraste() { System.out.println("Alto contraste activado"); }
    private static void restaurarDefault() { System.out.println("Valores restaurados"); }
    private static void asignarAtajo() { System.out.println("Atajo asignado"); }
    private static void listarAtajos() { System.out.println("Listando atajos"); }
}