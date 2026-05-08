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
public class CreditManagement {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- CREDITOS ---");
        System.out.println("1. Agregar deuda");
        System.out.println("2. Realizar pago");
        System.out.println("3. Verificar limite");
        System.out.println("4. Bloquear cuenta");
        System.out.println("5. Registrar pago");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: agregarDeuda(); break;
            case 2: realizarPago(); break;
            case 3: verificarLimite(); break;
            case 4: bloquearCuenta(); break;
            case 5: registrarPago(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void agregarDeuda() { System.out.println("Deuda agregada"); }
    private static void realizarPago() { System.out.println("Pago realizado"); }
    private static void verificarLimite() { System.out.println("Limite verificado"); }
    private static void bloquearCuenta() { System.out.println("Cuenta bloqueada"); }
    private static void registrarPago() { System.out.println("Pago registrado"); }
}
