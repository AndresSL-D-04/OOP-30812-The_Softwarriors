package ec.edu.espe.safestore.controller;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Product;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;

    public ProductController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("products");
    }

    private Document productToDoc(Product p) {
        return new Document("id", p.getId())
                .append("name", p.getName())
                .append("wholesalePrice", p.getWholesalePrice())
                .append("retailPrice", p.getRetailPrice())
                .append("stock", p.getStock())
                .append("minStock", p.getMinStock())
                .append("expiryDate", p.getExpiryDate());
    }

    private Product docToProduct(Document doc) {
        return new Product(
            doc.getInteger("id"),
            doc.getString("name") != null ? doc.getString("name") : "",
            doc.getDouble("wholesalePrice") != null ? doc.getDouble("wholesalePrice") : 0.0,
            doc.getDouble("retailPrice") != null ? doc.getDouble("retailPrice") : 0.0,
            doc.getInteger("stock") != null ? doc.getInteger("stock") : 0,
            doc.getInteger("minStock") != null ? doc.getInteger("minStock") : 0,
            doc.getString("expiryDate") != null ? doc.getString("expiryDate") : ""
        );
    }

    public boolean addProduct(Product product) {
        if (findById(product.getId()) != null) return false;
        collection.insertOne(productToDoc(product));
        return true;
    }

    public boolean updateProduct(Product product) {
        if (findById(product.getId()) == null) return false;
        collection.replaceOne(
            Filters.eq("id", product.getId()),
            productToDoc(product),
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
        return doc != null ? docToProduct(doc) : null;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Document doc : collection.find()) {
            products.add(docToProduct(doc));
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
        if (p == null) return false;
        p.setStock(newStock);
        return updateProduct(p);
    }
}