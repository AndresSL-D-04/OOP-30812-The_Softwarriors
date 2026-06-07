package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReservationSystem {
    private static final String RESERVATIONS_FILE = "reservations.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Reservation> reservations = new ArrayList<>();
    
    static {
        loadReservations();
        checkExpiredReservations();
    }
    
    public static class Reservation {
        private int reservationId;
        private int customerId;
        private String customerName;
        private String customerPhone;
        private List<ReservationItem> items;
        private LocalDateTime reservationDate;
        private LocalDateTime expiryDate;
        private String status;
        private String notes;
        
        public Reservation() {
            this.items = new ArrayList<>();
            this.reservationDate = LocalDateTime.now();
            this.expiryDate = LocalDateTime.now().plusDays(2);
            this.status = "active";
            this.notes = "";
        }
        
        public Reservation(int reservationId, int customerId, String customerName, 
                           String customerPhone, LocalDateTime expiryDate) {
            this.reservationId = reservationId;
            this.customerId = customerId;
            this.customerName = customerName;
            this.customerPhone = customerPhone;
            this.expiryDate = expiryDate;
            this.items = new ArrayList<>();
            this.reservationDate = LocalDateTime.now();
            this.status = "active";
            this.notes = "";
        }
        
        public int getReservationId() { return reservationId; }
        public void setReservationId(int reservationId) { this.reservationId = reservationId; }
        public int getCustomerId() { return customerId; }
        public void setCustomerId(int customerId) { this.customerId = customerId; }
        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }
        public String getCustomerPhone() { return customerPhone; }
        public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
        public List<ReservationItem> getItems() { return items; }
        public void setItems(List<ReservationItem> items) { this.items = items; }
        public LocalDateTime getReservationDate() { return reservationDate; }
        public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }
        public LocalDateTime getExpiryDate() { return expiryDate; }
        public void setExpiryDate(LocalDateTime expiryDate) { this.expiryDate = expiryDate; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getNotes() { return notes; }
        public void setNotes(String notes) { this.notes = notes; }
        
        public void addItem(ReservationItem item) {
            items.add(item);
        }
        
        public double getTotalValue() {
            return items.stream().mapToDouble(ReservationItem::getTotalPrice).sum();
        }
        
        public boolean isExpired() {
            return LocalDateTime.now().isAfter(expiryDate);
        }
        
        public void printDetails() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("\nDETALLE DE RESERVA #" + reservationId);
            System.out.println("Cliente: " + customerName);
            System.out.println("Telefono: " + customerPhone);
            System.out.println("Fecha reserva: " + reservationDate.format(formatter));
            System.out.println("Fecha vencimiento: " + expiryDate.format(formatter));
            System.out.println("Estado: " + status.toUpperCase());
            System.out.println("PRODUCTOS RESERVADOS:");
            for (ReservationItem item : items) {
                System.out.printf("  %s x%d = $%.2f\n", item.getProductName(), 
                                  item.getQuantity(), item.getTotalPrice());
            }
            System.out.printf("TOTAL: $%.2f\n", getTotalValue());
            if (!notes.isEmpty()) {
                System.out.println("Notas: " + notes);
            }
        }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return String.format("Reserva #%d | Cliente: %s | Total: $%.2f | Vence: %s | Estado: %s",
                reservationId, customerName, getTotalValue(), expiryDate.format(formatter), status.toUpperCase());
        }
    }
    
    public static class ReservationItem {
        private int productId;
        private String productName;
        private int quantity;
        private double unitPrice;
        private double totalPrice;
        
        public ReservationItem() {}
        
        public ReservationItem(int productId, String productName, int quantity, double unitPrice) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.totalPrice = quantity * unitPrice;
        }
        
        public int getProductId() { return productId; }
        public void setProductId(int productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { 
            this.quantity = quantity;
            this.totalPrice = this.quantity * this.unitPrice;
        }
        public double getUnitPrice() { return unitPrice; }
        public void setUnitPrice(double unitPrice) { 
            this.unitPrice = unitPrice;
            this.totalPrice = this.quantity * this.unitPrice;
        }
        public double getTotalPrice() { return totalPrice; }
        
        @Override
        public String toString() {
            return String.format("%s x%d = $%.2f", productName, quantity, totalPrice);
        }
    }
    
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nRESERVAS DE PRODUCTOS");
            System.out.println("1. Crear nueva reserva");
            System.out.println("2. Agregar producto a reserva");
            System.out.println("3. Listar reservas activas");
            System.out.println("4. Completar reserva");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Extender reserva");
            System.out.println("7. Buscar reserva por cliente");
            System.out.println("8. Ver reservas vencidas");
            System.out.println("9. Volver");
            System.out.print("Opcion: ");
            
            int opt = scanner.nextInt();
            scanner.nextLine();
            
            switch(opt) {
                case 1: createReservation(scanner); break;
                case 2: addProductToReservation(scanner); break;
                case 3: listActiveReservations(); break;
                case 4: completeReservation(scanner); break;
                case 5: cancelReservation(scanner); break;
                case 6: extendReservation(scanner); break;
                case 7: searchByCustomer(scanner); break;
                case 8: showExpiredReservations(); break;
                case 9: return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
    
    private static void createReservation(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nombre del cliente: ");
        String customerName = scanner.nextLine();
        
        System.out.print("Telefono del cliente: ");
        String customerPhone = scanner.nextLine();
        
        System.out.print("Dias de validez (1-7, default 2): ");
        int validDays = scanner.nextInt();
        if (validDays < 1) validDays = 2;
        
        LocalDateTime expiryDate = LocalDateTime.now().plusDays(validDays);
        int reservationId = reservations.size() + 1;
        
        Reservation reservation = new Reservation(reservationId, customerId, customerName, customerPhone, expiryDate);
        reservations.add(reservation);
        saveReservations();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Reserva #" + reservationId + " creada. Valida hasta: " + expiryDate.format(formatter));
    }
    
    private static void addProductToReservation(Scanner scanner) {
        System.out.print("ID de la reserva: ");
        int reservationId = scanner.nextInt();
        
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        if (!"active".equals(reservation.getStatus())) {
            System.out.println("Esta reserva no esta activa (Estado: " + reservation.getStatus() + ")");
            return;
        }
        
        System.out.print("ID del producto: ");
        int productId = scanner.nextInt();
        
        ProductManagement.Product product = ProductManagement.findById(productId);
        if (product == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.print("Cantidad: ");
        int quantity = scanner.nextInt();
        
        if (quantity > product.getStock()) {
            System.out.println("Stock insuficiente. Disponible: " + product.getStock());
            return;
        }
        
        ProductManagement.updateProductStock(productId, product.getStock() - quantity);
        
        ReservationItem item = new ReservationItem(productId, product.getName(), quantity, product.getRetailPrice());
        reservation.addItem(item);
        
        saveReservations();
        System.out.printf("Producto agregado: %d x %s\n", quantity, product.getName());
        System.out.printf("Valor total de la reserva: $%.2f\n", reservation.getTotalValue());
    }
    
    private static void listActiveReservations() {
        checkExpiredReservations();
        
        List<Reservation> active = new ArrayList<>();
        for (Reservation r : reservations) {
            if ("active".equals(r.getStatus())) {
                active.add(r);
            }
        }
        
        if (active.isEmpty()) {
            System.out.println("No hay reservas activas");
            return;
        }
        
        System.out.println("\nRESERVAS ACTIVAS");
        for (Reservation r : active) {
            System.out.println(r);
            System.out.println("  Productos: " + r.getItems().size());
            System.out.println("  Notas: " + (r.getNotes().isEmpty() ? "Ninguna" : r.getNotes()));
        }
    }
    
    private static void completeReservation(Scanner scanner) {
        System.out.print("ID de la reserva a completar: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();
        
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        if (!"active".equals(reservation.getStatus())) {
            System.out.println("Esta reserva no esta activa");
            return;
        }
        
        if (reservation.getItems().isEmpty()) {
            System.out.println("La reserva no tiene productos");
            return;
        }
        
        System.out.println("\nDETALLE DE RESERVA");
        System.out.println("Cliente: " + reservation.getCustomerName());
        System.out.println("Productos reservados:");
        for (ReservationItem item : reservation.getItems()) {
            System.out.println("  " + item);
        }
        System.out.printf("Total: $%.2f\n", reservation.getTotalValue());
        
        System.out.print("\nDesea completar como venta? (s/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("s")) {
            reservation.setStatus("completed");
            saveReservations();
            System.out.println("Reserva completada. Los productos han sido vendidos.");
        } else {
            System.out.println("Operacion cancelada");
        }
    }
    
    private static void cancelReservation(Scanner scanner) {
        System.out.print("ID de la reserva a cancelar: ");
        int reservationId = scanner.nextInt();
        
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        if (!"active".equals(reservation.getStatus())) {
            System.out.println("Esta reserva no esta activa");
            return;
        }
        
        for (ReservationItem item : reservation.getItems()) {
            ProductManagement.Product product = ProductManagement.findById(item.getProductId());
            if (product != null) {
                ProductManagement.updateProductStock(item.getProductId(), product.getStock() + item.getQuantity());
            }
        }
        
        reservation.setStatus("cancelled");
        saveReservations();
        System.out.println("Reserva cancelada. Stock devuelto al inventario.");
    }
    
    private static void extendReservation(Scanner scanner) {
        System.out.print("ID de la reserva: ");
        int reservationId = scanner.nextInt();
        
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reserva no encontrada");
            return;
        }
        
        if (!"active".equals(reservation.getStatus())) {
            System.out.println("Esta reserva no esta activa");
            return;
        }
        
        System.out.print("Dias adicionales (1-7): ");
        int extraDays = scanner.nextInt();
        
        LocalDateTime newExpiry = reservation.getExpiryDate().plusDays(extraDays);
        reservation.setExpiryDate(newExpiry);
        saveReservations();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Reserva extendida. Nueva fecha de vencimiento: " + newExpiry.format(formatter));
    }
    
    private static void searchByCustomer(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String name = scanner.nextLine().toLowerCase();
        
        List<Reservation> found = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getCustomerName().toLowerCase().contains(name)) {
                found.add(r);
            }
        }
        
        if (found.isEmpty()) {
            System.out.println("No se encontraron reservas para ese cliente");
            return;
        }
        
        System.out.println("\nRESERVAS DEL CLIENTE");
        for (Reservation r : found) {
            System.out.println(r);
        }
    }
    
    private static void showExpiredReservations() {
        checkExpiredReservations();
        
        List<Reservation> expired = new ArrayList<>();
        for (Reservation r : reservations) {
            if ("expired".equals(r.getStatus())) {
                expired.add(r);
            }
        }
        
        if (expired.isEmpty()) {
            System.out.println("No hay reservas vencidas");
            return;
        }
        
        System.out.println("\nRESERVAS VENCIDAS");
        for (Reservation r : expired) {
            System.out.println(r);
        }
    }
    
    private static void checkExpiredReservations() {
        boolean changed = false;
        for (Reservation r : reservations) {
            if ("active".equals(r.getStatus()) && r.isExpired()) {
                r.setStatus("expired");
                changed = true;
            }
        }
        if (changed) {
            saveReservations();
        }
    }
    
    private static Reservation findReservationById(int id) {
        for (Reservation r : reservations) {
            if (r.getReservationId() == id) {
                return r;
            }
        }
        return null;
    }
    
    // METODO AGREGADO PARA OBTENER TODAS LAS RESERVAS
    public static List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }
    
    private static void loadReservations() {
        try {
            File file = new File(RESERVATIONS_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Reservation>>(){}.getType();
                List<Reservation> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    reservations = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando reservas: " + e.getMessage());
        }
    }
    
    private static void saveReservations() {
        try {
            String json = gson.toJson(reservations);
            java.nio.file.Files.write(java.nio.file.Paths.get(RESERVATIONS_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando reservas: " + e.getMessage());
        }
    }
}