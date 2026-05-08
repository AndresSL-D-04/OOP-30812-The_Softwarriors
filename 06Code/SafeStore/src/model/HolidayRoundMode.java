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
public class HolidayRoundMode {
    
    public static void menu(Scanner sc) {
        System.out.println("\n--- REDONDEO FESTIVO ---");
        System.out.println("1. Activar modo festivo");
        System.out.println("2. Desactivar modo festivo");
        System.out.println("3. Configurar regla");
        System.out.println("4. Aplicar redondeo");
        System.out.println("5. Agregar dia festivo");
        System.out.println("6. Ver reporte");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: activarModoFestivo(); break;
            case 2: desactivarModoFestivo(); break;
            case 3: configurarRegla(); break;
            case 4: aplicarRedondeo(); break;
            case 5: agregarDiaFestivo(); break;
            case 6: verReporte(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void activarModoFestivo() { System.out.println("Modo festivo activado"); }
    private static void desactivarModoFestivo() { System.out.println("Modo festivo desactivado"); }
    private static void configurarRegla() { System.out.println("Regla configurada"); }
    private static void aplicarRedondeo() { System.out.println("Redondeo aplicado"); }
    private static void agregarDiaFestivo() { System.out.println("Dia festivo agregado"); }
    private static void verReporte() { System.out.println("Reporte generado"); }
}