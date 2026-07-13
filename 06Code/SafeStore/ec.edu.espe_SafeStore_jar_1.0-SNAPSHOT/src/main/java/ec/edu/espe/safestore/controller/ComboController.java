package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Combo;
import ec.edu.espe.safestore.model.ComboItem;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ComboController {

    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;
    private final ProductController productController;

    public ComboController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.collection = dbConnection.getCollection(Constants.COLLECTION_COMBOS);
        this.productController = new ProductController();
    }

    public boolean addCombo(Combo combo) {
        if (combo == null || findById(combo.getId()) != null) return false;
        collection.insertOne(DocumentConverter.comboToDoc(combo));
        return true;
    }

    public boolean updateCombo(Combo combo) {
        if (combo == null || findById(combo.getId()) == null) return false;
        collection.replaceOne(
            Filters.eq("id", combo.getId()),
            DocumentConverter.comboToDoc(combo),
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
        return doc != null ? DocumentConverter.docToCombo(doc) : null;
    }

    public List<Combo> getAllCombos() {
        List<Combo> combos = new ArrayList<>();
        for (Document doc : collection.find()) {
            combos.add(DocumentConverter.docToCombo(doc));
        }
        return combos;
    }

    public boolean addProductToCombo(int comboId, int productId, int quantity) {
        Combo combo = findById(comboId);
        if (combo == null || quantity <= 0) return false;
        Product product = productController.findById(productId);
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