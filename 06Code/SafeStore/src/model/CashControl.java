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

public class CashControl {
    
    public static void menu(Scanner sc) {
        System.out.println("\nCONTROL DE CAJA");
        System.out.println("1. Abrir caja");
        System.out.println("2. Cerrar caja");
        System.out.println("3. Calcular total");
        System.out.println("4. Calcular diferencia");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: abrirCaja(); break;
            case 2: cerrarCaja(); break;
            case 3: calcularTotal(); break;
            case 4: calcularDiferencia(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void abrirCaja() { System.out.println("Caja abierta"); }
    private static void cerrarCaja() { System.out.println("Caja cerrada"); }
    private static void calcularTotal() { System.out.println("Total calculado"); }
    private static void calcularDiferencia() { System.out.println("Diferencia calculada"); }
}