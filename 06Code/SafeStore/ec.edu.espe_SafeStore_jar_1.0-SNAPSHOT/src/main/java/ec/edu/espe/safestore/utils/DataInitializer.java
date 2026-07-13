/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.utils;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.safestore.model.User;
import org.bson.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
public class DataInitializer {
    private final MongoDBConnection dbConnection;
    
    public DataInitializer(MongoDBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    
    public void initializeDefaultUsers() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_USERS);
        if (collection.countDocuments() == 0) {
            List<User> defaults = List.of(
                new User("gerente", "1234", Constants.ROLE_MANAGER),
                new User("admin", "admin", Constants.ROLE_MANAGER),
                new User("cajero1", "1234", Constants.ROLE_CASHIER),
                new User("cajero", "cajero", Constants.ROLE_CASHIER)
            );
            for (User u : defaults) {
                collection.insertOne(DocumentConverter.userToDoc(u));
            }
            System.out.println("Usuarios por defecto inicializados");
        }
    }
    
    public void initializeCashSessions() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_CASH_SESSIONS);
        if (collection.countDocuments() == 0) {
            Document sample = new Document("sessionId", 1)
                    .append("openDate", LocalDateTime.now().toString())
                    .append("closeDate", LocalDateTime.now().plusHours(8).toString())
                    .append("initialBalance", 500.0)
                    .append("finalBalance", 1250.0)
                    .append("expectedBalance", 1250.0)
                    .append("difference", 0.0)
                    .append("isOpen", false)
                    .append("transactions", new ArrayList<Document>());
            collection.insertOne(sample);
            System.out.println("Sesión de caja de ejemplo inicializada");
        }
    }
    
    public void initializeAlertConfig() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_ALERT_CONFIG);
        if (collection.countDocuments() == 0) {
            Document sample = new Document("_id", "expiration_days")
                    .append("value", Constants.DEFAULT_ALERT_DAYS)
                    .append("description", "Días antes de vencimiento para mostrar alerta")
                    .append("updatedAt", LocalDate.now().toString());
            collection.insertOne(sample);
            System.out.println("Configuración de alertas inicializada");
        }
    }
    
    public void initializeBackups() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_BACKUPS);
        if (collection.countDocuments() == 0) {
            Document sample = new Document("backupId", 1)
                    .append("fileName", "backup_2024_01_01.zip")
                    .append("status", "completed")
                    .append("date", LocalDate.now().toString());
            collection.insertOne(sample);
            System.out.println("Backup de ejemplo inicializado");
        }
    }
    
    public void initializeInventoryLogs() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_INVENTORY_LOGS);
        if (collection.countDocuments() == 0) {
            Document sample = new Document("productId", 1)
                    .append("productName", "Producto de Ejemplo")
                    .append("previousStock", 10)
                    .append("newStock", 15)
                    .append("quantityChanged", 5)
                    .append("movementType", "PURCHASE")
                    .append("reason", "Stock inicial")
                    .append("timestamp", LocalDateTime.now().toString());
            collection.insertOne(sample);
            System.out.println("Log de inventario de ejemplo inicializado");
        }
    }
    
    public void initializeReports() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_GENERATED_REPORTS);
        if (collection.countDocuments() == 0) {
            Document sample = new Document("reportId", 1)
                    .append("type", Constants.REPORT_SLOW_MOVING)
                    .append("content", "Reporte de ejemplo: No se detectaron productos de lento movimiento")
                    .append("generatedDate", LocalDateTime.now().toString())
                    .append("generatedBy", "system");
            collection.insertOne(sample);
            System.out.println("Reporte de ejemplo inicializado");
        }
    }
    
    public void initializeSuppliers() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_SUPPLIERS);
        if (collection.countDocuments() == 0) {
            Document supplier1 = new Document("id", 1)
                    .append("name", "Distribuidora XYZ")
                    .append("contactPerson", "Juan Perez")
                    .append("phone", "0999999999")
                    .append("email", "juan@xyz.com")
                    .append("address", "Calle 123")
                    .append("creditTerm", 30)
                    .append("currentDebt", 0)
                    .append("creditLimit", 5000)
                    .append("isActive", true)
                    .append("invoiceIds", new ArrayList<Integer>());
            collection.insertOne(supplier1);
            
            Document supplier2 = new Document("id", 2)
                    .append("name", "Alimentos SA")
                    .append("contactPerson", "Maria Gomez")
                    .append("phone", "0888888888")
                    .append("email", "maria@alimentos.com")
                    .append("address", "Av. Principal")
                    .append("creditTerm", 15)
                    .append("currentDebt", 0)
                    .append("creditLimit", 3000)
                    .append("isActive", true)
                    .append("invoiceIds", new ArrayList<Integer>());
            collection.insertOne(supplier2);
            System.out.println("Proveedores por defecto inicializados");
        }
    }
    
    public void initializeAll() {
        initializeDefaultUsers();
        initializeCashSessions();
        initializeAlertConfig();
        initializeBackups();
        initializeInventoryLogs();
        initializeReports();
        initializeSuppliers();
        System.out.println("Todos los datos inicializados");
    }
}
