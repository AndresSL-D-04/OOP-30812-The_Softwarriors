package ec.edu.espe.safestore.controller;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Combo;
import ec.edu.espe.safestore.model.ComboItem;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ComboController {

    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;
    private ProductController productController;

    public ComboController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("combos");
        productController = new ProductController();
    }

    private Document comboToDoc(Combo c) {
        List<Document> itemDocs = new ArrayList<>();
        for (ComboItem item : c.getItems()) {
            itemDocs.add(new Document("productId", item.getProductId())
                    .append("productName", item.getProductName())
                    .append("productPrice", item.getProductPrice())
                    .append("quantity", item.getQuantity()));
        }
        return new Document("id", c.getId())
                .append("name", c.getName())
                .append("description", c.getDescription())
                .append("comboPrice", c.getComboPrice())
                .append("isActive", c.isActive())
                .append("items", itemDocs);
    }

    private Combo docToCombo(Document doc) {
        Combo c = new Combo(
            doc.getInteger("id"),
            doc.getString("name"),
            doc.getString("description"),
            doc.getDouble("comboPrice") != null ? doc.getDouble("comboPrice") : 0.0
        );
        c.setActive(Boolean.TRUE.equals(doc.getBoolean("isActive")));
        List<Document> itemDocs = doc.getList("items", Document.class);
        if (itemDocs != null) {
            for (Document itemDoc : itemDocs) {
                c.addItem(new ComboItem(
                    itemDoc.getInteger("productId"),
                    itemDoc.getString("productName"),
                    itemDoc.getDouble("productPrice") != null ? itemDoc.getDouble("productPrice") : 0.0,
                    itemDoc.getInteger("quantity") != null ? itemDoc.getInteger("quantity") : 0
                ));
            }
        }
        return c;
    }

    public boolean addCombo(Combo combo) {
        if (findById(combo.getId()) != null) return false;
        collection.insertOne(comboToDoc(combo));
        return true;
    }

    public boolean updateCombo(Combo combo) {
        if (findById(combo.getId()) == null) return false;
        collection.replaceOne(
            Filters.eq("id", combo.getId()),
            comboToDoc(combo),
            new ReplaceOptions().upsert(false)
        );
        return true;
    }

    public boolean deleteCombo(int id) {
        if (findById(id) == null) return false;
        collection.deleteOne(Filters.eq("id", id));
        return true;
    }

    public Combo findById(int id) {
        Document doc = collection.find(Filters.eq("id", id)).first();
        return doc != null ? docToCombo(doc) : null;
    }

    public List<Combo> getAllCombos() {
        List<Combo> combos = new ArrayList<>();
        for (Document doc : collection.find()) combos.add(docToCombo(doc));
        return combos;
    }

    public boolean addProductToCombo(int comboId, int productId, int quantity) {
        Combo combo = findById(comboId);
        if (combo == null) return false;
        ec.edu.espe.safestore.model.Product product = productController.findById(productId);
        if (product == null) return false;
        combo.addItem(new ComboItem(productId, product.getName(), product.getRetailPrice(), quantity));
        return updateCombo(combo);
    }

    public boolean activateCombo(int id) {
        Combo combo = findById(id);
        if (combo == null) return false;
        combo.setActive(true);
        return updateCombo(combo);
    }

    public boolean deactivateCombo(int id) {
        Combo combo = findById(id);
        if (combo == null) return false;
        combo.setActive(false);
        return updateCombo(combo);
    }
}