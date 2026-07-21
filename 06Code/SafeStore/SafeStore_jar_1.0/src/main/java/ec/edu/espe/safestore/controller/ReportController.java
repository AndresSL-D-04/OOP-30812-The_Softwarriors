package ec.edu.espe.safestore.controller;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.utils.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReportController {
    
    private final ProductController productController;
    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;
    private int nextReportId;
    
    public ReportController() {
        this.productController = new ProductController();
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.collection = dbConnection.getCollection(Constants.COLLECTION_GENERATED_REPORTS);
        this.nextReportId = (int) (collection.countDocuments() + 1);
    }
    
    public List<Product> getSlowMovingProducts() {
        List<Product> slowMoving = new ArrayList<>();
        for (Product p : productController.getAllProducts()) {
            double turnoverRate = calculateTurnoverRate(p);
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
        if (rate < 0.2) return "Considerar descuento para liquidar";
        if (rate < 0.5) return "Reducir pedidos a proveedores";
        return "Monitorear ventas";
    }
    
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== REPORTE DE PRODUCTOS DE LENTO MOVIMIENTO ===\n");
        report.append("Fecha: ").append(java.time.LocalDate.now()).append("\n\n");
        List<Product> slowProducts = getSlowMovingProducts();
        for (Product p : slowProducts) {
            report.append("Producto: ").append(p.getName()).append("\n");
            report.append("  Stock Actual: ").append(p.getStock()).append("\n");
            report.append("  Stock Mínimo: ").append(p.getMinStock()).append("\n");
            report.append("  Tasa de Rotación: ").append(String.format("%.2f", calculateTurnoverRate(p))).append("\n");
            report.append("  Recomendación: ").append(getRecommendation(p)).append("\n\n");
        }
        if (slowProducts.isEmpty()) {
            report.append("No se detectaron productos de lento movimiento\n");
        }
        saveReport(report.toString());
        return report.toString();
    }
    
    private void saveReport(String content) {
        Document doc = new Document("reportId", nextReportId++)
                .append("type", Constants.REPORT_SLOW_MOVING)
                .append("content", content)
                .append("generatedDate", LocalDateTime.now().toString())
                .append("generatedBy", System.getProperty("user.name"));
        collection.insertOne(doc);
        System.out.println("Reporte guardado con ID: " + (nextReportId - 1));
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