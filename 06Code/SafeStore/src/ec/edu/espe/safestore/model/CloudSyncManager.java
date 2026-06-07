package ec.edu.espe.safestore.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.safestore.model.ProductManagement.Product;
import org.bson.Document;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class CloudSyncManager {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    static {
        MongoDBConnection.connect();
        createJsonFilesIfNotExist();
    }
    
    // METODO PARA CREAR ARCHIVOS JSON SI NO EXISTEN
    private static void createJsonFilesIfNotExist() {
        String[] files = {"products.json", "sales.json", "suppliers.json", 
                          "reservations.json", "credits.json", "combos.json", "backups.json"};
        
        for (String fileName : files) {
            File file = new File(fileName);
            if (!file.exists()) {
                try {
                    Files.write(Paths.get(fileName), "[]".getBytes());
                    System.out.println("Archivo creado: " + fileName);
                } catch (IOException e) {
                    System.out.println("Error creando " + fileName + ": " + e.getMessage());
                }
            }
        }
    }
    
    // ==================== PRODUCTOS ====================
    
    public static void uploadProducts() {
        try {
            List<Product> products = ProductManagement.getAllProducts();
            if (products.isEmpty()) {
                System.out.println("No hay productos para subir");
                return;
            }
            
            MongoCollection<Document> collection = MongoDBConnection.getCollection("products");
            collection.deleteMany(new Document());
            
            for (Product p : products) {
                Document doc = new Document("id", p.getId())
                        .append("name", p.getName())
                        .append("wholesalePrice", p.getWholesalePrice())
                        .append("retailPrice", p.getRetailPrice())
                        .append("stock", p.getStock())
                        .append("minStock", p.getMinStock())
                        .append("expiryDate", p.getExpiryDate());
                collection.insertOne(doc);
            }
            
            System.out.println("Productos subidos a la nube: " + products.size());
        } catch (Exception e) {
            System.out.println("Error subiendo productos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void downloadProducts() {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("products");
            List<Product> products = new ArrayList<>();
            
            for (Document doc : collection.find()) {
                Integer id = doc.getInteger("id");
                if (id == null) {
                    continue;
                }
                
                Product p = new Product(
                        id,
                        doc.getString("name") != null ? doc.getString("name") : "Sin nombre",
                        doc.getDouble("wholesalePrice") != null ? doc.getDouble("wholesalePrice") : 0.0,
                        doc.getDouble("retailPrice") != null ? doc.getDouble("retailPrice") : 0.0,
                        doc.getInteger("stock") != null ? doc.getInteger("stock") : 0,
                        doc.getInteger("minStock") != null ? doc.getInteger("minStock") : 0,
                        doc.getString("expiryDate") != null ? doc.getString("expiryDate") : "2026-12-31"
                );
                products.add(p);
            }
            
            if (products.isEmpty()) {
                System.out.println("No hay productos en la nube");
                return;
            }
            
            String json = gson.toJson(products);
            Files.write(Paths.get("products.json"), json.getBytes());
            
            for (Product p : products) {
                Product existing = ProductManagement.findById(p.getId());
                if (existing != null) {
                    existing.setStock(p.getStock());
                    existing.setRetailPrice(p.getRetailPrice());
                    existing.setWholesalePrice(p.getWholesalePrice());
                    existing.setName(p.getName());
                    existing.setMinStock(p.getMinStock());
                    existing.setExpiryDate(p.getExpiryDate());
                } else {
                    ProductManagement.addProduct(p);
                }
            }
            
            System.out.println("Productos descargados desde la nube: " + products.size());
        } catch (Exception e) {
            System.out.println("Error descargando productos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // ==================== VENTAS ====================
    
    public static void uploadSales() {
        try {
            File file = new File("sales.json");
            if (!file.exists()) {
                Files.write(Paths.get("sales.json"), "[]".getBytes());
                System.out.println("sales.json creado automaticamente");
            }
            
            String content = new String(Files.readAllBytes(Paths.get("sales.json")));
            MongoCollection<Document> collection = MongoDBConnection.getCollection("sales");
            collection.deleteMany(new Document());
            
            Document doc = new Document("filename", "sales.json")
                    .append("data", content)
                    .append("uploadDate", new java.util.Date().toString());
            collection.insertOne(doc);
            
            System.out.println("Ventas subidas a la nube");
        } catch (Exception e) {
            System.out.println("Error subiendo ventas: " + e.getMessage());
        }
    }
    
    public static void downloadSales() {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("sales");
            Document doc = collection.find(new Document()).first();
            
            if (doc == null || !doc.containsKey("data")) {
                System.out.println("No hay ventas en la nube");
                Files.write(Paths.get("sales.json"), "[]".getBytes());
                return;
            }
            
            String content = doc.getString("data");
            Files.write(Paths.get("sales.json"), content.getBytes());
            System.out.println("Ventas descargadas desde la nube");
        } catch (Exception e) {
            System.out.println("Error descargando ventas: " + e.getMessage());
        }
    }
    
    // ==================== PROVEEDORES ====================
    
    public static void uploadSuppliers() {
        try {
            File file = new File("suppliers.json");
            if (!file.exists()) {
                Files.write(Paths.get("suppliers.json"), "[]".getBytes());
                System.out.println("suppliers.json creado automaticamente");
            }
            
            String content = new String(Files.readAllBytes(Paths.get("suppliers.json")));
            MongoCollection<Document> collection = MongoDBConnection.getCollection("suppliers");
            collection.deleteMany(new Document());
            
            Document doc = new Document("filename", "suppliers.json")
                    .append("data", content)
                    .append("uploadDate", new java.util.Date().toString());
            collection.insertOne(doc);
            
            System.out.println("Proveedores subidos a la nube");
        } catch (Exception e) {
            System.out.println("Error subiendo proveedores: " + e.getMessage());
        }
    }
    
    public static void downloadSuppliers() {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("suppliers");
            Document doc = collection.find(new Document()).first();
            
            if (doc == null || !doc.containsKey("data")) {
                System.out.println("No hay proveedores en la nube");
                Files.write(Paths.get("suppliers.json"), "[]".getBytes());
                return;
            }
            
            String content = doc.getString("data");
            Files.write(Paths.get("suppliers.json"), content.getBytes());
            System.out.println("Proveedores descargados desde la nube");
        } catch (Exception e) {
            System.out.println("Error descargando proveedores: " + e.getMessage());
        }
    }
    
    // ==================== RESERVAS ====================
    
    public static void uploadReservations() {
        try {
            File file = new File("reservations.json");
            if (!file.exists()) {
                Files.write(Paths.get("reservations.json"), "[]".getBytes());
                System.out.println("reservations.json creado automaticamente");
            }
            
            String content = new String(Files.readAllBytes(Paths.get("reservations.json")));
            MongoCollection<Document> collection = MongoDBConnection.getCollection("reservations");
            collection.deleteMany(new Document());
            
            Document doc = new Document("filename", "reservations.json")
                    .append("data", content)
                    .append("uploadDate", new java.util.Date().toString());
            collection.insertOne(doc);
            
            System.out.println("Reservas subidas a la nube");
        } catch (Exception e) {
            System.out.println("Error subiendo reservas: " + e.getMessage());
        }
    }
    
    public static void downloadReservations() {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("reservations");
            Document doc = collection.find(new Document()).first();
            
            if (doc == null || !doc.containsKey("data")) {
                System.out.println("No hay reservas en la nube");
                Files.write(Paths.get("reservations.json"), "[]".getBytes());
                return;
            }
            
            String content = doc.getString("data");
            Files.write(Paths.get("reservations.json"), content.getBytes());
            System.out.println("Reservas descargadas desde la nube");
        } catch (Exception e) {
            System.out.println("Error descargando reservas: " + e.getMessage());
        }
    }
    
    // ==================== CREDITOS ====================
    
    public static void uploadCredits() {
        try {
            File file = new File("credits.json");
            if (!file.exists()) {
                Files.write(Paths.get("credits.json"), "[]".getBytes());
                System.out.println("credits.json creado automaticamente");
            }
            
            String content = new String(Files.readAllBytes(Paths.get("credits.json")));
            MongoCollection<Document> collection = MongoDBConnection.getCollection("credits");
            collection.deleteMany(new Document());
            
            Document doc = new Document("filename", "credits.json")
                    .append("data", content)
                    .append("uploadDate", new java.util.Date().toString());
            collection.insertOne(doc);
            
            System.out.println("Creditos subidos a la nube");
        } catch (Exception e) {
            System.out.println("Error subiendo creditos: " + e.getMessage());
        }
    }
    
    public static void downloadCredits() {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("credits");
            Document doc = collection.find(new Document()).first();
            
            if (doc == null || !doc.containsKey("data")) {
                System.out.println("No hay creditos en la nube");
                Files.write(Paths.get("credits.json"), "[]".getBytes());
                return;
            }
            
            String content = doc.getString("data");
            Files.write(Paths.get("credits.json"), content.getBytes());
            System.out.println("Creditos descargados desde la nube");
        } catch (Exception e) {
            System.out.println("Error descargando creditos: " + e.getMessage());
        }
    }
    
    // ==================== COMBOS ====================
    
    public static void uploadCombos() {
        try {
            File file = new File("combos.json");
            if (!file.exists()) {
                Files.write(Paths.get("combos.json"), "[]".getBytes());
                System.out.println("combos.json creado automaticamente");
            }
            
            String content = new String(Files.readAllBytes(Paths.get("combos.json")));
            MongoCollection<Document> collection = MongoDBConnection.getCollection("combos");
            collection.deleteMany(new Document());
            
            Document doc = new Document("filename", "combos.json")
                    .append("data", content)
                    .append("uploadDate", new java.util.Date().toString());
            collection.insertOne(doc);
            
            System.out.println("Combos subidos a la nube");
        } catch (Exception e) {
            System.out.println("Error subiendo combos: " + e.getMessage());
        }
    }
    
    public static void downloadCombos() {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("combos");
            Document doc = collection.find(new Document()).first();
            
            if (doc == null || !doc.containsKey("data")) {
                System.out.println("No hay combos en la nube");
                Files.write(Paths.get("combos.json"), "[]".getBytes());
                return;
            }
            
            String content = doc.getString("data");
            Files.write(Paths.get("combos.json"), content.getBytes());
            System.out.println("Combos descargados desde la nube");
        } catch (Exception e) {
            System.out.println("Error descargando combos: " + e.getMessage());
        }
    }
    
    // ==================== SUBIR Y DESCARGAR TODO ====================
    
    public static void uploadAll() {
        System.out.println("=== SUBIENDO TODOS LOS DATOS A LA NUBE ===");
        uploadProducts();
        uploadSales();
        uploadSuppliers();
        uploadReservations();
        uploadCredits();
        uploadCombos();
        System.out.println("=== SUBIDA COMPLETADA ===");
    }
    
    public static void downloadAll() {
        System.out.println("=== DESCARGANDO TODOS LOS DATOS DESDE LA NUBE ===");
        downloadProducts();
        downloadSales();
        downloadSuppliers();
        downloadReservations();
        downloadCredits();
        downloadCombos();
        System.out.println("=== DESCARGA COMPLETADA ===");
    }
}