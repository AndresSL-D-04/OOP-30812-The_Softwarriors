
package ec.edu.espe.safestore.controller;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 * 
 */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Sale;
import ec.edu.espe.safestore.model.SaleItem;
import ec.edu.espe.safestore.model.Product;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleController {

    private MongoDBConnection dbConnection;
    private MongoCollection<Document> salesCollection;
    private MongoCollection<Document> holdCollection;
    private Sale pendingSale;
    private ProductController productController;

    public SaleController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        salesCollection = dbConnection.getCollection("sales");
        holdCollection = dbConnection.getCollection("sales_hold");
        productController = new ProductController();
        loadHold();
    }

    private Document saleToDoc(Sale s) {
        List<Document> itemDocs = new ArrayList<>();
        for (SaleItem item : s.getItems()) {
            itemDocs.add(new Document("productId", item.getProductId())
                    .append("productName", item.getProductName())
                    .append("quantity", item.getQuantity())
                    .append("unitPrice", item.getUnitPrice())
                    .append("totalPrice", item.getTotalPrice()));
        }
        return new Document("saleId", s.getSaleId())
                .append("customerName", s.getCustomerName())
                .append("saleType", s.getSaleType())
                .append("paymentMethod", s.getPaymentMethod())
                .append("date", s.getDate() != null ? s.getDate().toString() : LocalDateTime.now().toString())
                .append("subtotal", s.getSubtotal())
                .append("tax", s.getTax())
                .append("total", s.getTotal())
                .append("items", itemDocs);
    }

    private Sale docToSale(Document doc) {
        Sale s = new Sale(
            doc.getInteger("saleId"),
            doc.getString("customerName"),
            doc.getString("saleType"),
            doc.getString("paymentMethod")
        );
        s.setSubtotal(doc.getDouble("subtotal") != null ? doc.getDouble("subtotal") : 0.0);
        s.setTax(doc.getDouble("tax") != null ? doc.getDouble("tax") : 0.0);
        s.setTotal(doc.getDouble("total") != null ? doc.getDouble("total") : 0.0);
        List<Document> itemDocs = doc.getList("items", Document.class);
        if (itemDocs != null) {
            for (Document itemDoc : itemDocs) {
                SaleItem item = new SaleItem(
                    itemDoc.getInteger("productId"),
                    itemDoc.getString("productName"),
                    itemDoc.getInteger("quantity") != null ? itemDoc.getInteger("quantity") : 0,
                    itemDoc.getDouble("unitPrice") != null ? itemDoc.getDouble("unitPrice") : 0.0
                );
                s.getItems().add(item);
            }
        }
        return s;
    }

    public void startNewSale(int saleId, String customerName, String saleType, String paymentMethod) {
        pendingSale = new Sale(saleId, customerName, saleType, paymentMethod);
    }

    public boolean addProductToCurrentSale(int productId, int quantity) {
        if (pendingSale == null) return false;
        Product product = productController.findById(productId);
        if (product == null || quantity > product.getStock()) return false;
        double unitPrice = "wholesale".equalsIgnoreCase(pendingSale.getSaleType()) && quantity >= 12
                           ? product.getWholesalePrice() : product.getRetailPrice();
        pendingSale.addItem(new SaleItem(productId, product.getName(), quantity, unitPrice));
        productController.updateStock(productId, product.getStock() - quantity);
        return true;
    }

    public Sale getCurrentSale() {
        return pendingSale;
    }

    public boolean finalizeSale() {
        if (pendingSale == null || pendingSale.getItems().isEmpty()) return false;
        salesCollection.insertOne(saleToDoc(pendingSale));
        pendingSale = null;
        return true;
    }

    public void holdCurrentSale() {
        if (pendingSale != null) {
            holdCollection.deleteMany(new Document()); // solo 1 hold a la vez
            holdCollection.insertOne(saleToDoc(pendingSale));
            pendingSale = null;
        }
    }

    public void resumeHoldSale() {
        loadHold();
    }

    private void loadHold() {
        Document doc = holdCollection.find().first();
        if (doc != null) pendingSale = docToSale(doc);
    }

    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        for (Document doc : salesCollection.find()) sales.add(docToSale(doc));
        return sales;
    }

    public Sale findSaleById(int id) {
        Document doc = salesCollection.find(Filters.eq("saleId", id)).first();
        return doc != null ? docToSale(doc) : null;
    }
}