package ec.edu.espe.safestore.controller;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.utils.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Vizcaino, The-Softwarriors, @ESPE
 */
public class StockController {
    private final ProductController productController;
    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> logCollection;
  
    public StockController() {
        this.productController = new ProductController();
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.logCollection = dbConnection.getCollection(Constants.COLLECTION_INVENTORY_LOGS);
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
        if (p == null || !ValidationUtil.isValidStock(newStock)) return false;
        int oldStock = p.getStock();
        boolean result = productController.updateStock(productId, newStock);
        if (result) {
            Document log = new Document("productId", productId)
                    .append("productName", p.getName())
                    .append("previousStock", oldStock)
                    .append("newStock", newStock)
                    .append("quantityChanged", newStock - oldStock)
                    .append("movementType", "ADJUSTMENT")
                    .append("reason", "Actualización manual de stock")
                    .append("timestamp", LocalDateTime.now().toString());
            logCollection.insertOne(log);
            System.out.println("Stock actualizado para: " + p.getName());
        }
        return result;
    }
    
    public boolean updateMinStock(int productId, int newMinStock) {
        Product p = productController.findById(productId);
        if (p == null || !ValidationUtil.isValidMinStock(newMinStock)) return false;
        p.setMinStock(newMinStock);
        return productController.updateProduct(p);
    }
    
    public int calculateSuggestedOrder(Product product) {
        int suggested = product.getMinStock() * 2 - product.getStock();
        return Math.max(suggested, product.getMinStock());
    }
    
    public List<String> generateOrderList() {
        List<String> orderList = new ArrayList<>();
        for (Product p : getLowStockProducts()) {
            orderList.add(p.getName() + " - Pedir " + calculateSuggestedOrder(p) + " unidades");
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