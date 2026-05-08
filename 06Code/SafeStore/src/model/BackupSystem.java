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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class BackupSystem {
    private static final String ARCHIVO = "backups.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private int backupId;
    private String fileName;
    private String status;
    private String fecha;
    
    public BackupSystem() {}
    
    public BackupSystem(int backupId, String fileName, String status, String fecha) {
        this.backupId = backupId;
        this.fileName = fileName;
        this.status = status;
        this.fecha = fecha;
    }
    
    public static void menu(Scanner sc) {
        System.out.println("\nRESPALDOS");
        System.out.println("1. Crear respaldo");
        System.out.println("2. Restaurar respaldo");
        System.out.println("3. Eliminar respaldo");
        System.out.println("4. Subir a la nube");
        System.out.println("5. Descargar de la nube");
        System.out.println("6. Ver todos los respaldos");
        System.out.print("Opcion: ");
        int opt = sc.nextInt();
        
        switch(opt) {
            case 1: crearRespaldo(sc); break;
            case 2: restaurarRespaldo(sc); break;
            case 3: eliminarRespaldo(sc); break;
            case 4: subirANube(); break;
            case 5: descargarDeNube(); break;
            case 6: verRespaldos(); break;
            default: System.out.println("Opcion invalida");
        }
    }
    
    private static void crearRespaldo(Scanner sc) {
        System.out.print("Nombre del respaldo: ");
        String nombre = sc.next();
        int id = (int)(System.currentTimeMillis() % 10000);
        BackupSystem backup = new BackupSystem(id, nombre, "activo", java.time.LocalDate.now().toString());
        
        List<BackupSystem> lista = cargarRespaldos();
        lista.add(backup);
        guardarRespaldos(lista);
        System.out.println("Respaldo creado con ID: " + id);
    }
    
    private static void restaurarRespaldo(Scanner sc) {
        System.out.print("ID del respaldo a restaurar: ");
        int id = sc.nextInt();
        List<BackupSystem> lista = cargarRespaldos();
        for (BackupSystem b : lista) {
            if (b.backupId == id) {
                System.out.println("Restaurando respaldo: " + b.fileName);
                return;
            }
        }
        System.out.println("Respaldo no encontrado");
    }
    
    private static void eliminarRespaldo(Scanner sc) {
        System.out.print("ID del respaldo a eliminar: ");
        int id = sc.nextInt();
        List<BackupSystem> lista = cargarRespaldos();
        boolean eliminado = lista.removeIf(b -> b.backupId == id);
        if (eliminado) {
            guardarRespaldos(lista);
            System.out.println("Respaldo eliminado");
        } else {
            System.out.println("Respaldo no encontrado");
        }
    }
    
    private static void verRespaldos() {
        List<BackupSystem> lista = cargarRespaldos();
        if (lista.isEmpty()) {
            System.out.println("No hay respaldos guardados");
        } else {
            System.out.println("\nRESPALDOS GUARDADOS");
            for (BackupSystem b : lista) {
                System.out.println("ID: " + b.backupId + " | Nombre: " + b.fileName + " | Estado: " + b.status + " | Fecha: " + b.fecha);
            }
        }
    }
    
    private static void subirANube() { 
        System.out.println("Respaldo subido a la nube"); 
    }
    
    private static void descargarDeNube() { 
        System.out.println("Respaldo descargado de la nube"); 
    }
    
    private static List<BackupSystem> cargarRespaldos() {
        try {
            File file = new File(ARCHIVO);
            if (file.exists()) {
                String contenido = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type tipoLista = new TypeToken<ArrayList<BackupSystem>>(){}.getType();
                List<BackupSystem> lista = gson.fromJson(contenido, tipoLista);
                if (lista != null) {
                    return lista;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar respaldos: " + e.getMessage());
        }
        return new ArrayList<>();
    }
    
    private static void guardarRespaldos(List<BackupSystem> lista) {
        try {
            String json = gson.toJson(lista);
            java.nio.file.Files.write(java.nio.file.Paths.get(ARCHIVO), json.getBytes());
            System.out.println("Datos guardados en " + ARCHIVO);
        } catch (Exception e) {
            System.out.println("Error al guardar respaldos: " + e.getMessage());
        }
    }
}