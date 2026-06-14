
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
package ec.edu.espe.safestore.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import ec.edu.espe.safestore.controller.MongoDBConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Backup {
    private int backupId;
    private String fileName;
    private String status;
    private LocalDate date;
    
    private static MongoDBConnection dbConnection;
    private static MongoCollection<Document> collection;
    
    private static void initDB() {
        if (dbConnection == null) {
            dbConnection = new MongoDBConnection();
            dbConnection.connect();
            collection = dbConnection.getCollection("backups");
            
            if (collection.countDocuments() == 0) {
                Document sample = new Document("backupId", 1)
                        .append("fileName", "backup_2024_01_01.zip")
                        .append("status", "completed")
                        .append("date", LocalDate.now().toString());
                collection.insertOne(sample);
                System.out.println("Coleccion backups creada con datos de ejemplo");
            }
        }
    }
    
    public Backup() {
        initDB();
    }
    
    public Backup(int backupId, String fileName, String status, LocalDate date) {
        this.backupId = backupId;
        this.fileName = fileName;
        this.status = status;
        this.date = date;
        initDB();
    }
    
    public int getBackupId() { return backupId; }
    public void setBackupId(int backupId) { this.backupId = backupId; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public boolean save() {
        initDB();
        Document doc = new Document("backupId", backupId)
                .append("fileName", fileName)
                .append("status", status)
                .append("date", date.toString());
        collection.insertOne(doc);
        return true;
    }
    
    public static Backup findById(int id) {
        initDB();
        Document doc = collection.find(Filters.eq("backupId", id)).first();
        if (doc != null) {
            Backup backup = new Backup();
            Object idObj = doc.get("backupId");
            if (idObj instanceof Number) {
                backup.setBackupId(((Number) idObj).intValue());
            }
            backup.setFileName(doc.getString("fileName"));
            backup.setStatus(doc.getString("status"));
            String dateStr = doc.getString("date");
            if (dateStr != null) {
                backup.setDate(LocalDate.parse(dateStr));
            }
            return backup;
        }
        return null;
    }
    
    public static List<Backup> getAllBackups() {
        initDB();
        List<Backup> backups = new ArrayList<>();
        for (Document doc : collection.find()) {
            Backup backup = new Backup();
            Object idObj = doc.get("backupId");
            if (idObj instanceof Number) {
                backup.setBackupId(((Number) idObj).intValue());
            }
            backup.setFileName(doc.getString("fileName"));
            backup.setStatus(doc.getString("status"));
            String dateStr = doc.getString("date");
            if (dateStr != null) {
                backup.setDate(LocalDate.parse(dateStr));
            }
            backups.add(backup);
        }
        return backups;
    }
    
    public static boolean updateStatus(int backupId, String newStatus) {
        initDB();
        Document doc = collection.find(Filters.eq("backupId", backupId)).first();
        if (doc != null) {
            doc.put("status", newStatus);
            collection.replaceOne(Filters.eq("backupId", backupId), doc);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Backup{backupId=" + backupId + ", fileName=" + fileName + ", date=" + date + "}";
    }
}