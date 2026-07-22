package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class CloudSyncController {
    
    private final MongoDBConnection dbConnection;
    private final ProductController productController;
    
    public CloudSyncController() {
        this.dbConnection = new MongoDBConnection();
        this.productController = new ProductController();
    }
    
    public boolean connect() {
        return dbConnection.connect();
    }
    
    public void disconnect() {
        dbConnection.close();
    }
    
    public boolean isConnected() {
        return dbConnection.isConnected();
    }
    
    public void uploadProducts() {
        List<Product> products = productController.getAllProducts();
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_PRODUCTS);
        collection.deleteMany(new Document());
        for (Product p : products) {
            collection.insertOne(DocumentConverter.productToDoc(p));
        }
        System.out.println("Productos subidos: " + products.size());
    }
    
    public void downloadProducts() {
        MongoCollection<Document> collection = dbConnection.getCollection(Constants.COLLECTION_PRODUCTS);
        List<Product> products = new ArrayList<>();
        for (Document doc : collection.find()) {
            Integer id = doc.getInteger("id");
            if (id == null) continue;
            Product p = DocumentConverter.docToProduct(doc);
            products.add(p);
        }
        for (Product p : products) {
            Product existing = productController.findById(p.getId());
            if (existing != null) {
                productController.updateStock(p.getId(), p.getStock());
            } else {
                productController.addProduct(p);
            }
        }
        System.out.println("Productos descargados: " + products.size());
    }
    
    public void uploadAll() {
        System.out.println("=== SUBIENDO TODOS LOS DATOS ===");
        uploadProducts();
        System.out.println("=== SUBIDA COMPLETADA ===");
    }
    
    public void downloadAll() {
        System.out.println("=== DESCARGANDO TODOS LOS DATOS ===");
        downloadProducts();
        System.out.println("=== DESCARGA COMPLETADA ===");
    }
}