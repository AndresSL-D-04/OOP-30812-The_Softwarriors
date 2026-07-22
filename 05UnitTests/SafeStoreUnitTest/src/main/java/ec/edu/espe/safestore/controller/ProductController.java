package ec.edu.espe.safestore.controller;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;

    public ProductController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.collection = dbConnection.getCollection(Constants.COLLECTION_PRODUCTS);
    }

    public boolean addProduct(Product product) {
        if (!ValidationUtil.isValidProduct(product) || findById(product.getId()) != null) {
            return false;
        }
        collection.insertOne(DocumentConverter.productToDoc(product));
        return true;
    }

    public boolean updateProduct(Product product) {
        if (!ValidationUtil.isValidProduct(product) || findById(product.getId()) == null) {
            return false;
        }
        collection.replaceOne(
            Filters.eq("id", product.getId()),
            DocumentConverter.productToDoc(product),
            new ReplaceOptions().upsert(false)
        );
        return true;
    }

    public boolean deleteProduct(int id) {
        if (findById(id) == null) return false;
        collection.deleteOne(Filters.eq("id", id));
        return true;
    }

    public Product findById(int id) {
        Document doc = collection.find(Filters.eq("id", id)).first();
        return doc != null ? DocumentConverter.docToProduct(doc) : null;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Document doc : collection.find()) {
            products.add(DocumentConverter.docToProduct(doc));
        }
        return products;
    }

    public List<Product> getLowStockProducts() {
        List<Product> lowStock = new ArrayList<>();
        for (Product p : getAllProducts()) {
            if (p.getStock() <= p.getMinStock()) lowStock.add(p);
        }
        return lowStock;
    }

    public boolean updateStock(int id, int newStock) {
        Product p = findById(id);
        if (p == null || !ValidationUtil.isValidStock(newStock)) return false;
        p.setStock(newStock);
        return updateProduct(p);
    }
}