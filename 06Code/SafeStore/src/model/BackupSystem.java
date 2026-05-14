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
    private static final String FILE_NAME = "backups.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private int backupId;
    private String fileName;
    private String status;
    private String date;
    
    public BackupSystem() {}
    
    public BackupSystem(int backupId, String fileName, String status, String date) {
        this.backupId = backupId;
        this.fileName = fileName;
        this.status = status;
        this.date = date;
    }
    
    public static void menu(Scanner sc) {
        System.out.println("\nBackups");
        System.out.println("1. Create backup");
        System.out.println("2. Restore backup");
        System.out.println("3. Delete backup");
        System.out.println("4. Upload to cloud");
        System.out.println("5. Download from cloud");
        System.out.println("6. View all backups");
        System.out.print("Option: ");
        int option = sc.nextInt();
        
        switch(option) {
            case 1: createBackup(sc); break;
            case 2: restoreBackup(sc); break;
            case 3: deleteBackup(sc); break;
            case 4: uploadToCloud(); break;
            case 5: downloadFromCloud(); break;
            case 6: viewBackups(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void createBackup(Scanner sc) {
        System.out.print("Backup name: ");
        String name = sc.next();
        int id = (int)(System.currentTimeMillis() % 10000);
        
        BackupSystem backup = new BackupSystem(
            id, 
            name, 
            "active", 
            java.time.LocalDate.now().toString()
        );
        
        List<BackupSystem> backupList = loadBackups();
        backupList.add(backup);
        saveBackups(backupList);
        
        System.out.println("Backup created with ID: " + id);
    }
    
    private static void restoreBackup(Scanner sc) {
        System.out.print("Backup ID to restore: ");
        int id = sc.nextInt();
        
        List<BackupSystem> backupList = loadBackups();
        
        for (BackupSystem b : backupList) {
            if (b.backupId == id) {
                System.out.println("Restoring backup: " + b.fileName);
                return;
            }
        }
        
        System.out.println("Backup not found");
    }
    
    private static void deleteBackup(Scanner sc) {
        System.out.print("Backup ID to delete: ");
        int id = sc.nextInt();
        
        List<BackupSystem> backupList = loadBackups();
        
        boolean deleted = backupList.removeIf(b -> b.backupId == id);
        
        if (deleted) {
            saveBackups(backupList);
            System.out.println("Backup deleted");
        } else {
            System.out.println("Backup not found");
        }
    }
    
    private static void viewBackups() {
        List<BackupSystem> backupList = loadBackups();
        
        if (backupList.isEmpty()) {
            System.out.println("No backups saved");
        } else {
            System.out.println("\nSAVED BACKUPS");
            
            for (BackupSystem b : backupList) {
                System.out.println(
                    "ID: " + b.backupId +
                    " | Name: " + b.fileName +
                    " | Status: " + b.status +
                    " | Date: " + b.date
                );
            }
        }
    }
    
    private static void uploadToCloud() { 
        System.out.println("Backup uploaded to cloud"); 
    }
    
    private static void downloadFromCloud() { 
        System.out.println("Backup downloaded from cloud"); 
    }
    
    private static List<BackupSystem> loadBackups() {
        try {
            File file = new File(FILE_NAME);
            
            if (file.exists()) {
                String content = new String(
                    java.nio.file.Files.readAllBytes(file.toPath())
                );
                
                Type listType = new TypeToken<ArrayList<BackupSystem>>(){}.getType();
                
                List<BackupSystem> backupList = gson.fromJson(content, listType);
                
                if (backupList != null) {
                    return backupList;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading backups: " + e.getMessage());
        }
        
        return new ArrayList<>();
    }
    
    private static void saveBackups(List<BackupSystem> backupList) {
        try {
            String json = gson.toJson(backupList);
            
            java.nio.file.Files.write(
                java.nio.file.Paths.get(FILE_NAME),
                json.getBytes()
            );
            
            System.out.println("Data saved in " + FILE_NAME);
            
        } catch (Exception e) {
            System.out.println("Error saving backups: " + e.getMessage());
        }
    }
}