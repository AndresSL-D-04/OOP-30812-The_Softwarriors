package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Product;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ExpirationController {
    
    private ProductController productController;
    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;
    private int alertDays;
    
    public ExpirationController() {
        productController = new ProductController();
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("alert_config");
        
        if (collection.countDocuments() == 0) {
            Document sample = new Document("_id", "expiration_days")
                    .append("value", 30)
                    .append("description", "Days before expiration to show alert")
                    .append("updatedAt", LocalDate.now().toString());
            collection.insertOne(sample);
            System.out.println("Coleccion alert_config creada con datos de ejemplo");
        }
        
        loadAlertDays();
    }
    
    private void loadAlertDays() {
        Document doc = collection.find(Filters.eq("_id", "expiration_days")).first();
        if (doc != null) {
            Object valueObj = doc.get("value");
            if (valueObj instanceof Number) {
                this.alertDays = ((Number) valueObj).intValue();
            } else {
                this.alertDays = 30;
            }
        } else {
            this.alertDays = 30;
        }
    }
    
    private void saveAlertDays() {
        Document doc = new Document("_id", "expiration_days")
                .append("value", alertDays)
                .append("updatedAt", LocalDate.now().toString());
        collection.replaceOne(Filters.eq("_id", "expiration_days"), doc, new ReplaceOptions().upsert(true));
    }
    
    public void setAlertDays(int days) {
        this.alertDays = days;
        saveAlertDays();
    }
    
    public int getAlertDays() {
        return alertDays;
    }
    
    public List<Product> getExpiringSoonProducts() {
        List<Product> expiring = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        for (Product p : productController.getAllProducts()) {
            if (p.getExpiryDate() != null && !p.getExpiryDate().isEmpty()) {
                try {
                    LocalDate expiry = LocalDate.parse(p.getExpiryDate());
                    long daysLeft = ChronoUnit.DAYS.between(today, expiry);
                    if (daysLeft <= alertDays && daysLeft > 0) {
                        expiring.add(p);
                    }
                } catch (Exception e) {}
            }
        }
        return expiring;
    }
    
    public List<Product> getExpiredProducts() {
        List<Product> expired = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        for (Product p : productController.getAllProducts()) {
            if (p.getExpiryDate() != null && !p.getExpiryDate().isEmpty()) {
                try {
                    LocalDate expiry = LocalDate.parse(p.getExpiryDate());
                    if (expiry.isBefore(today)) {
                        expired.add(p);
                    }
                } catch (Exception e) {}
            }
        }
        return expired;
    }
    
    public double calculateDiscount(Product product) {
        if (product.getExpiryDate() == null || product.getExpiryDate().isEmpty()) return 0;
        
        try {
            LocalDate today = LocalDate.now();
            LocalDate expiry = LocalDate.parse(product.getExpiryDate());
            long daysLeft = ChronoUnit.DAYS.between(today, expiry);
            
            if (daysLeft <= 7 && daysLeft > 3) return 0.30;
            else if (daysLeft <= 15 && daysLeft > 7) return 0.20;
            else if (daysLeft <= 30 && daysLeft > 15) return 0.10;
            else if (daysLeft <= 0) return 0.50;
        } catch (Exception e) {}
        return 0;
    }
    
    public String getDiscountDescription(Product product) {
        double discount = calculateDiscount(product);
        if (discount == 0.30) return "30% (Last week)";
        if (discount == 0.20) return "20% (Two weeks)";
        if (discount == 0.10) return "10% (One month)";
        if (discount == 0.50) return "50% (EXPIRED - Do not sell)";
        return "No discount";
    }
}