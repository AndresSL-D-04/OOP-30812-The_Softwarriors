package ec.edu.espe.safestore.controller;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.model.Sale;
import ec.edu.espe.safestore.model.SaleItem;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleController {

    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> salesCollection;
    private final MongoCollection<Document> holdCollection;
    private final ProductController productController;
    private Sale pendingSale;

    public SaleController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.salesCollection = dbConnection.getCollection(Constants.COLLECTION_SALES);
        this.holdCollection = dbConnection.getCollection(Constants.COLLECTION_SALES_HOLD);
        this.productController = new ProductController();
        loadHold();
    }

    public void startNewSale(int saleId, String customerName, String saleType, String paymentMethod) {
        pendingSale = new Sale(saleId, customerName, saleType, paymentMethod);
        System.out.println("Nueva venta #" + saleId + " iniciada");
    }

    public boolean addProductToCurrentSale(int productId, int quantity) {
        if (pendingSale == null || quantity <= 0) return false;
        Product product = productController.findById(productId);
        if (product == null || quantity > product.getStock()) return false;
        double unitPrice = Constants.SALE_TYPE_WHOLESALE.equalsIgnoreCase(pendingSale.getSaleType()) && quantity >= 12
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
        salesCollection.insertOne(DocumentConverter.saleToDoc(pendingSale));
        System.out.println("Venta #" + pendingSale.getSaleId() + " finalizada");
        pendingSale = null;
        return true;
    }

    public void holdCurrentSale() {
        if (pendingSale != null) {
            holdCollection.deleteMany(new Document());
            holdCollection.insertOne(DocumentConverter.saleToDoc(pendingSale));
            System.out.println("Venta en espera guardada");
            pendingSale = null;
        }
    }

    public void resumeHoldSale() {
        loadHold();
        if (pendingSale != null) {
            System.out.println("Venta en espera recuperada");
        }
    }

    private void loadHold() {
        Document doc = holdCollection.find().first();
        if (doc != null) {
            pendingSale = DocumentConverter.docToSale(doc);
        }
    }

    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        for (Document doc : salesCollection.find()) {
            sales.add(DocumentConverter.docToSale(doc));
        }
        return sales;
    }

    public Sale findSaleById(int id) {
        Document doc = salesCollection.find(Filters.eq("saleId", id)).first();
        return doc != null ? DocumentConverter.docToSale(doc) : null;
    }
}