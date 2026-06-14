package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.model.Product;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReportController {
    
    private ProductController productController;
    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;
    private int nextReportId;
    
    public ReportController() {
        productController = new ProductController();
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("generated_reports");
        nextReportId = (int) (collection.countDocuments() + 1);
        if (collection.countDocuments() == 0) {
            Document sample = new Document("reportId", 1)
                    .append("type", "SLOW_MOVING")
                    .append("content", "Sample report: No slow moving products detected")
                    .append("generatedDate", LocalDateTime.now().toString())
                    .append("generatedBy", "system");
            collection.insertOne(sample);
            nextReportId = 2;
        }
    }
    
    public List<Product> getSlowMovingProducts() {
        List<Product> slowMoving = new ArrayList<>();
        for (Product p : productController.getAllProducts()) {
            double turnoverRate = (double) p.getStock() / (p.getMinStock() + 1);
            if (turnoverRate < 0.5) {
                slowMoving.add(p);
            }
        }
        return slowMoving;
    }
    
    public double calculateTurnoverRate(Product product) {
        return (double) product.getStock() / (product.getMinStock() + 1);
    }
    
    public String getRecommendation(Product product) {
        double rate = calculateTurnoverRate(product);
        if (rate < 0.2) return "Consider discount to liquidate";
        if (rate < 0.5) return "Reduce supplier orders";
        return "Monitor sales";
    }
    
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== SLOW MOVING PRODUCTS REPORT ===\n");
        report.append("Date: ").append(java.time.LocalDate.now()).append("\n\n");
        
        for (Product p : getSlowMovingProducts()) {
            report.append("Product: ").append(p.getName()).append("\n");
            report.append("  Current Stock: ").append(p.getStock()).append("\n");
            report.append("  Minimum Stock: ").append(p.getMinStock()).append("\n");
            report.append("  Turnover Rate: ").append(String.format("%.2f", calculateTurnoverRate(p))).append("\n");
            report.append("  Recommendation: ").append(getRecommendation(p)).append("\n\n");
        }
        
        if (getSlowMovingProducts().isEmpty()) {
            report.append("No slow moving products detected\n");
        }
        
        saveReport(report.toString());
        return report.toString();
    }
    
    private void saveReport(String content) {
        Document doc = new Document("reportId", nextReportId++)
                .append("type", "SLOW_MOVING")
                .append("content", content)
                .append("generatedDate", LocalDateTime.now().toString())
                .append("generatedBy", System.getProperty("user.name"));
        collection.insertOne(doc);
    }
    
    public List<Document> getAllReports() {
        List<Document> reports = new ArrayList<>();
        for (Document doc : collection.find()) {
            reports.add(doc);
        }
        return reports;
    }
    
    public Document getReportById(int reportId) {
        return collection.find(Filters.eq("reportId", reportId)).first();
    }
}