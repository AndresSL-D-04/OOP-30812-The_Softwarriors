/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Scanner;
/**
 *
 * @author Ronald Tipan, The Softwarriors, @ESPE
 */
public class ExpirationControl {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- CONTROL DE VENCIMIENTO ---");
        System.out.println("1. Generar alerta");
        System.out.println("2. Enviar notificacion");
        System.out.println("3. Verificar fechas");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: generarAlerta(); break;
            case 2: enviarNotificacion(); break;
            case 3: verificarFechas(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void generarAlerta() { System.out.println("Alerta generada"); }
    private static void enviarNotificacion() { System.out.println("Notificacion enviada"); }
    private static void verificarFechas() { System.out.println("Fechas verificadas"); }
}