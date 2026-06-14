package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Product;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StockController {
    
    private ProductController productController;
    private MongoDBConnection dbConnection;
    private MongoCollection<Document> logCollection;
    
    public StockController() {
        productController = new ProductController();
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        logCollection = dbConnection.getCollection("inventory_logs");
        if (logCollection.countDocuments() == 0) {
            Document sample = new Document("productId", 1)
                    .append("productName", "Sample Product")
                    .append("previousStock", 10)
                    .append("newStock", 15)
                    .append("quantityChanged", 5)
                    .append("movementType", "PURCHASE")
                    .append("reason", "Initial stock")
                    .append("timestamp", LocalDateTime.now().toString());
            logCollection.insertOne(sample);
        }
    }
    
    public List<Product> getLowStockProducts() {
        return productController.getLowStockProducts();
    }
    
    public List<Product> getCriticalStockProducts() {
        List<Product> critical = new ArrayList<>();
        for (Product p : productController.getAllProducts()) {
            if (p.getStock() <= p.getMinStock() / 2) {
                critical.add(p);
            }
        }
        return critical;
    }
    
    public boolean updateStock(int productId, int newStock) {
        Product p = productController.findById(productId);
        if (p == null) return false;
        
        int oldStock = p.getStock();
        boolean result = productController.updateStock(productId, newStock);
        
        if (result) {
            Document log = new Document("productId", productId)
                    .append("productName", p.getName())
                    .append("previousStock", oldStock)
                    .append("newStock", newStock)
                    .append("quantityChanged", newStock - oldStock)
                    .append("movementType", "ADJUSTMENT")
                    .append("reason", "Manual stock update")
                    .append("timestamp", LocalDateTime.now().toString());
            logCollection.insertOne(log);
        }
        return result;
    }
    
    public boolean updateMinStock(int productId, int newMinStock) {
        Product p = productController.findById(productId);
        if (p == null) return false;
        
        p.setMinStock(newMinStock);
        productController.updateProduct(p);
        return true;
    }
    
    public int calculateSuggestedOrder(Product product) {
        int suggested = product.getMinStock() * 2 - product.getStock();
        return suggested < 0 ? product.getMinStock() : suggested;
    }
    
    public List<String> generateOrderList() {
        List<String> orderList = new ArrayList<>();
        for (Product p : getLowStockProducts()) {
            orderList.add(p.getName() + " - Order " + calculateSuggestedOrder(p) + " units");
        }
        return orderList;
    }
    
    public List<Document> getStockHistory(int productId) {
        List<Document> history = new ArrayList<>();
        for (Document doc : logCollection.find(new Document("productId", productId))) {
            history.add(doc);
        }
        return history;
    }
}