package ec.edu.espe.safestore.model;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalDate;
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class BackupSystem {
    private static final String BACKUP_FILE = "backups.json";
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
    
    public static void menu(Scanner scanner) {
        System.out.println("\nBACKUPS");
        System.out.println("1. Create backup");
        System.out.println("2. Restore backup");
        System.out.println("3. Delete backup");
        System.out.println("4. Upload to cloud");
        System.out.println("5. Download from cloud");
        System.out.println("6. View all backups");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        
        switch(option) {
            case 1: createBackup(scanner); break;
            case 2: restoreBackup(scanner); break;
            case 3: deleteBackup(scanner); break;
            case 4: uploadToCloud(); break;
            case 5: downloadFromCloud(); break;
            case 6: viewBackups(); break;
            default: System.out.println("Invalid option");
        }
    }
    
    private static void createBackup(Scanner scanner) {
        System.out.print("Backup name: ");
        String name = scanner.next();
        int id = (int)(System.currentTimeMillis() % 10000);
        BackupSystem backup = new BackupSystem(id, name, "active", LocalDate.now().toString());
        
        List<BackupSystem> backupList = loadBackups();
        backupList.add(backup);
        saveBackups(backupList);
        System.out.println("Backup created with ID: " + id);
    }
    
    private static void restoreBackup(Scanner scanner) {
        System.out.print("Backup ID to restore: ");
        int id = scanner.nextInt();
        List<BackupSystem> backupList = loadBackups();
        for (BackupSystem backup : backupList) {
            if (backup.backupId == id) {
                System.out.println("Restoring backup: " + backup.fileName);
                return;
            }
        }
        System.out.println("Backup not found");
    }
    
    private static void deleteBackup(Scanner scanner) {
        System.out.print("Backup ID to delete: ");
        int id = scanner.nextInt();
        List<BackupSystem> backupList = loadBackups();
        boolean deleted = backupList.removeIf(backup -> backup.backupId == id);
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
            for (BackupSystem backup : backupList) {
                System.out.println("ID: " + backup.backupId + " | Name: " + backup.fileName + " | Status: " + backup.status + " | Date: " + backup.date);
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
            File file = new File(BACKUP_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
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
            java.nio.file.Files.write(java.nio.file.Paths.get(BACKUP_FILE), json.getBytes());
            System.out.println("Data saved to " + BACKUP_FILE);
        } catch (Exception e) {
            System.out.println("Error saving backups: " + e.getMessage());
        }
    }
}