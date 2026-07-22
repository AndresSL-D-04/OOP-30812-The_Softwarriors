package ec.edu.espe.safestore.controller;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.Product;
import ec.edu.espe.safestore.model.Reservation;
import ec.edu.espe.safestore.model.ReservationItem;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {

    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;
    private final ProductController productController;

    public ReservationController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.collection = dbConnection.getCollection(Constants.COLLECTION_RESERVATIONS);
        this.productController = new ProductController();
        checkExpiredReservations();
    }

    public boolean addReservation(Reservation reservation) {
        if (reservation == null) return false;
        collection.insertOne(DocumentConverter.reservationToDoc(reservation));
        return true;
    }

    public Reservation findById(int id) {
        Document doc = collection.find(Filters.eq("reservationId", id)).first();
        return DocumentConverter.docToReservation(doc);
    }

    public List<Reservation> getActiveReservations() {
        List<Reservation> active = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("status", Constants.RESERVATION_ACTIVE))) {
            Reservation r = DocumentConverter.docToReservation(doc);
            if (r != null) active.add(r);
        }
        return active;
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> all = new ArrayList<>();
        for (Document doc : collection.find()) {
            Reservation r = DocumentConverter.docToReservation(doc);
            if (r != null) all.add(r);
        }
        return all;
    }

    private void saveReservation(Reservation r) {
        if (r == null) return;
        collection.replaceOne(
            Filters.eq("reservationId", r.getReservationId()),
            DocumentConverter.reservationToDoc(r),
            new ReplaceOptions().upsert(false)
        );
    }

    public boolean addProductToReservation(int reservationId, int productId, int quantity) {
        Reservation reservation = findById(reservationId);
        if (reservation == null || !Constants.RESERVATION_ACTIVE.equals(reservation.getStatus()) || quantity <= 0) {
            return false;
        }
        Product product = productController.findById(productId);
        if (product == null || quantity > product.getStock()) return false;
        reservation.addItem(new ReservationItem(productId, product.getName(), quantity, product.getRetailPrice()));
        productController.updateStock(productId, product.getStock() - quantity);
        saveReservation(reservation);
        return true;
    }

    public boolean completeReservation(int reservationId) {
        Reservation r = findById(reservationId);
        if (r == null || !Constants.RESERVATION_ACTIVE.equals(r.getStatus())) return false;
        r.setStatus(Constants.RESERVATION_COMPLETED);
        saveReservation(r);
        System.out.println("Reserva #" + reservationId + " completada");
        return true;
    }

    public boolean cancelReservation(int reservationId) {
        Reservation r = findById(reservationId);
        if (r == null || !Constants.RESERVATION_ACTIVE.equals(r.getStatus())) return false;
        for (ReservationItem item : r.getItems()) {
            Product product = productController.findById(item.getProductId());
            if (product != null) {
                productController.updateStock(item.getProductId(), product.getStock() + item.getQuantity());
            }
        }
        r.setStatus(Constants.RESERVATION_CANCELLED);
        saveReservation(r);
        System.out.println("Reserva #" + reservationId + " cancelada");
        return true;
    }

    public boolean extendReservation(int reservationId, int extraDays) {
        Reservation r = findById(reservationId);
        if (r == null || !Constants.RESERVATION_ACTIVE.equals(r.getStatus()) || extraDays <= 0) return false;
        r.setExpiryDate(r.getExpiryDate().plusDays(Math.min(extraDays, Constants.MAX_RESERVATION_DAYS)));
        saveReservation(r);
        System.out.println("Reserva #" + reservationId + " extendida por " + extraDays + " días");
        return true;
    }

    private void checkExpiredReservations() {
        for (Reservation r : getAllReservations()) {
            if (r != null && Constants.RESERVATION_ACTIVE.equals(r.getStatus()) && r.isExpired()) {
                r.setStatus(Constants.RESERVATION_EXPIRED);
                saveReservation(r);
                System.out.println("Reserva #" + r.getReservationId() + " expirada");
            }
        }
    }
}