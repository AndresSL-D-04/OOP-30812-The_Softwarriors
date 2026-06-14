package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Reservation;
import ec.edu.espe.safestore.model.ReservationItem;
import ec.edu.espe.safestore.model.Product;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {

    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;
    private ProductController productController;

    public ReservationController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("reservations");
        productController = new ProductController();
        checkExpiredReservations();
    }

    private Document reservationToDoc(Reservation r) {
        List<Document> itemDocs = new ArrayList<>();
        if (r.getItems() != null) {
            for (ReservationItem item : r.getItems()) {
                itemDocs.add(new Document("productId", item.getProductId())
                        .append("productName", item.getProductName() != null ? item.getProductName() : "")
                        .append("quantity", item.getQuantity())
                        .append("unitPrice", item.getUnitPrice())
                        .append("totalPrice", item.getTotalPrice()));
            }
        }
        return new Document("reservationId", r.getReservationId())
                .append("customerId", r.getCustomerId())
                .append("customerName", r.getCustomerName() != null ? r.getCustomerName() : "")
                .append("customerPhone", r.getCustomerPhone() != null ? r.getCustomerPhone() : "")
                .append("reservationDate", r.getReservationDate() != null ? r.getReservationDate().toString() : LocalDateTime.now().toString())
                .append("expiryDate", r.getExpiryDate() != null ? r.getExpiryDate().toString() : LocalDateTime.now().plusDays(2).toString())
                .append("status", r.getStatus() != null ? r.getStatus() : "active")
                .append("notes", r.getNotes() != null ? r.getNotes() : "")
                .append("items", itemDocs);
    }

    private Reservation docToReservation(Document doc) {
        if (doc == null) return null;
        
        Reservation r = new Reservation();
        
        Object reservationIdObj = doc.get("reservationId");
        if (reservationIdObj instanceof Number) {
            r.setReservationId(((Number) reservationIdObj).intValue());
        }
        
        Object customerIdObj = doc.get("customerId");
        if (customerIdObj instanceof Number) {
            r.setCustomerId(((Number) customerIdObj).intValue());
        }
        
        r.setCustomerName(doc.getString("customerName") != null ? doc.getString("customerName") : "");
        r.setCustomerPhone(doc.getString("customerPhone") != null ? doc.getString("customerPhone") : "");
        r.setStatus(doc.getString("status") != null ? doc.getString("status") : "active");
        r.setNotes(doc.getString("notes") != null ? doc.getString("notes") : "");
        
        String expiryStr = doc.getString("expiryDate");
        if (expiryStr != null && !expiryStr.isEmpty()) {
            try {
                r.setExpiryDate(LocalDateTime.parse(expiryStr));
            } catch (Exception e) {
                r.setExpiryDate(LocalDateTime.now().plusDays(2));
            }
        } else {
            r.setExpiryDate(LocalDateTime.now().plusDays(2));
        }
        
        String resDateStr = doc.getString("reservationDate");
        if (resDateStr != null && !resDateStr.isEmpty()) {
            try {
                r.setReservationDate(LocalDateTime.parse(resDateStr));
            } catch (Exception e) {
                r.setReservationDate(LocalDateTime.now());
            }
        } else {
            r.setReservationDate(LocalDateTime.now());
        }
        
        List<Document> itemDocs = doc.getList("items", Document.class);
        if (itemDocs != null) {
            for (Document itemDoc : itemDocs) {
                Object productIdObj = itemDoc.get("productId");
                Integer productId = null;
                if (productIdObj instanceof Number) {
                    productId = ((Number) productIdObj).intValue();
                }
                
                String productName = itemDoc.getString("productName");
                
                Object quantityObj = itemDoc.get("quantity");
                Integer quantity = null;
                if (quantityObj instanceof Number) {
                    quantity = ((Number) quantityObj).intValue();
                }
                
                Object unitPriceObj = itemDoc.get("unitPrice");
                Double unitPrice = null;
                if (unitPriceObj instanceof Number) {
                    unitPrice = ((Number) unitPriceObj).doubleValue();
                }
                
                if (productId != null && quantity != null && unitPrice != null) {
                    ReservationItem item = new ReservationItem(productId, productName != null ? productName : "", quantity, unitPrice);
                    r.addItem(item);
                }
            }
        }
        
        return r;
    }

    public boolean addReservation(Reservation reservation) {
        if (reservation == null) return false;
        collection.insertOne(reservationToDoc(reservation));
        return true;
    }

    public Reservation findById(int id) {
        Document doc = collection.find(Filters.eq("reservationId", id)).first();
        return docToReservation(doc);
    }

    public List<Reservation> getActiveReservations() {
        List<Reservation> active = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("status", "active"))) {
            Reservation r = docToReservation(doc);
            if (r != null) {
                active.add(r);
            }
        }
        return active;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> all = new ArrayList<>();
        for (Document doc : collection.find()) {
            Reservation r = docToReservation(doc);
            if (r != null) {
                all.add(r);
            }
        }
        return all;
    }

    private void saveReservation(Reservation r) {
        if (r == null) return;
        collection.replaceOne(
            Filters.eq("reservationId", r.getReservationId()),
            reservationToDoc(r),
            new ReplaceOptions().upsert(false)
        );
    }

    public boolean addProductToReservation(int reservationId, int productId, int quantity) {
        Reservation reservation = findById(reservationId);
        if (reservation == null || !"active".equals(reservation.getStatus())) return false;
        Product product = productController.findById(productId);
        if (product == null || quantity > product.getStock()) return false;
        reservation.addItem(new ReservationItem(productId, product.getName(), quantity, product.getRetailPrice()));
        productController.updateStock(productId, product.getStock() - quantity);
        saveReservation(reservation);
        return true;
    }

    public boolean completeReservation(int reservationId) {
        Reservation r = findById(reservationId);
        if (r == null || !"active".equals(r.getStatus())) return false;
        r.setStatus("completed");
        saveReservation(r);
        return true;
    }

    public boolean cancelReservation(int reservationId) {
        Reservation r = findById(reservationId);
        if (r == null || !"active".equals(r.getStatus())) return false;
        for (ReservationItem item : r.getItems()) {
            Product product = productController.findById(item.getProductId());
            if (product != null)
                productController.updateStock(item.getProductId(), product.getStock() + item.getQuantity());
        }
        r.setStatus("cancelled");
        saveReservation(r);
        return true;
    }

    public boolean extendReservation(int reservationId, int extraDays) {
        Reservation r = findById(reservationId);
        if (r == null || !"active".equals(r.getStatus())) return false;
        r.setExpiryDate(r.getExpiryDate().plusDays(extraDays));
        saveReservation(r);
        return true;
    }

    private void checkExpiredReservations() {
        for (Reservation r : getAllReservations()) {
            if (r != null && "active".equals(r.getStatus()) && r.isExpired()) {
                r.setStatus("expired");
                saveReservation(r);
            }
        }
    }
}