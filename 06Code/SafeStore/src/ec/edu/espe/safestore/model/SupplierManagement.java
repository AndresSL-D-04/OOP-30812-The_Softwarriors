/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;
public class SupplierManagement {
    private static final String SUPPLIERS_FILE = "suppliers.json";
    private static final String INVOICES_FILE = "invoices.json";
    private static final String PRICE_HISTORY_FILE = "price_history.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Supplier> suppliers = new ArrayList<>();
    private static List<SupplierInvoice> invoices = new ArrayList<>();
    private static Map<String, List<Double>> priceHistory = new HashMap<>();
    
    static {
        loadSuppliers();
        loadInvoices();
        loadPriceHistory();
    }
    
    public static class Supplier {
        private int id;
        private String name;
        private String contactPerson;
        private String phone;
        private String email;
        private String address;
        private double creditTerm;
        private double currentDebt;
        private double creditLimit;
        private List<Integer> invoiceIds;
        private boolean isActive;
        
        public Supplier() {
            this.invoiceIds = new ArrayList<>();
            this.isActive = true;
        }
        
        public Supplier(int id, String name, String contactPerson, String phone, 
                       String email, String address, double creditTerm, double creditLimit) {
            this.id = id;
            this.name = name;
            this.contactPerson = contactPerson;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.creditTerm = creditTerm;
            this.creditLimit = creditLimit;
            this.currentDebt = 0;
            this.invoiceIds = new ArrayList<>();
            this.isActive = true;
        }
        
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getContactPerson() { return contactPerson; }
        public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
        public double getCreditTerm() { return creditTerm; }
        public void setCreditTerm(double creditTerm) { this.creditTerm = creditTerm; }
        public double getCurrentDebt() { return currentDebt; }
        public void setCurrentDebt(double currentDebt) { this.currentDebt = currentDebt; }
        public double getCreditLimit() { return creditLimit; }
        public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
        public List<Integer> getInvoiceIds() { return invoiceIds; }
        public void setInvoiceIds(List<Integer> invoiceIds) { this.invoiceIds = invoiceIds; }
        public boolean isActive() { return isActive; }
        public void setActive(boolean active) { isActive = active; }
        
        public void addInvoiceId(int invoiceId) {
            invoiceIds.add(invoiceId);
        }
        
        @Override
        public String toString() {
            return String.format("ID:%d | %s | Contacto:%s | Credito:%.0f dias | Deuda:$%.2f",
                             id, name, contactPerson, creditTerm, currentDebt);
        }
    }
    
    public static class SupplierInvoice {
        private int invoiceId;
        private int supplierId;
        private String invoiceNumber;
        private LocalDate date;
        private LocalDate dueDate;
        private List<InvoiceItem> items;
        private double subtotal;
        private double tax;
        private double total;
        private String status;
        
        public SupplierInvoice() {
            this.items = new ArrayList<>();
            this.status = "pending";
            this.date = LocalDate.now();
        }
        
        public SupplierInvoice(int invoiceId, int supplierId, String invoiceNumber, LocalDate dueDate) {
            this.invoiceId = invoiceId;
            this.supplierId = supplierId;
            this.invoiceNumber = invoiceNumber;
            this.dueDate = dueDate;
            this.items = new ArrayList<>();
            this.status = "pending";
            this.date = LocalDate.now();
        }
        
        public int getInvoiceId() { return invoiceId; }
        public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }
        public int getSupplierId() { return supplierId; }
        public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
        public String getInvoiceNumber() { return invoiceNumber; }
        public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
        public LocalDate getDate() { return date; }
        public void setDate(LocalDate date) { this.date = date; }
        public LocalDate getDueDate() { return dueDate; }
        public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
        public List<InvoiceItem> getItems() { return items; }
        public void setItems(List<InvoiceItem> items) { 
            this.items = items;
            calculateTotals();
        }
        public double getSubtotal() { return subtotal; }
        public double getTax() { return tax; }
        public double getTotal() { return total; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        
        public void addItem(InvoiceItem item) {
            items.add(item);
            calculateTotals();
        }
        
        private void calculateTotals() {
            subtotal = items.stream().mapToDouble(InvoiceItem::getTotalPrice).sum();
            tax = subtotal * 0.15;
            total = subtotal + tax;
        }
        
        public boolean isOverdue() {
            return LocalDate.now().isAfter(dueDate) && "pending".equals(status);
        }
        
        @Override
        public String toString() {
            return String.format("Factura #%d | Proveedor:%d | Total:$%.2f | Vence:%s | Estado:%s",
                             invoiceId, supplierId, total, dueDate, status);
        }
    }
    
    public static class InvoiceItem {
        private int productId;
        private String productName;
        private int quantity;
        private double unitCost;
        private double totalPrice;
        
        public InvoiceItem() {}
        
        public InvoiceItem(int productId, String productName, int quantity, double unitCost) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.unitCost = unitCost;
            this.totalPrice = quantity * unitCost;
        }
        
        public int getProductId() { return productId; }
        public void setProductId(int productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { 
            this.quantity = quantity;
            this.totalPrice = this.quantity * this.unitCost;
        }
        public double getUnitCost() { return unitCost; }
        public void setUnitCost(double unitCost) { 
            this.unitCost = unitCost;
            this.totalPrice = this.quantity * this.unitCost;
        }
        public double getTotalPrice() { return totalPrice; }
    }
    
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nGESTION DE PROVEEDORES");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Registrar factura");
            System.out.println("4. Ver facturas pendientes");
            System.out.println("5. Registrar pago");
            System.out.println("6. Detectar aumento de costos");
            System.out.println("7. Sugerir precio de venta");
            System.out.println("8. Comparar precios vs mercado");
            System.out.println("9. Volver");
            System.out.print("Opcion: ");
            
            int opt = scanner.nextInt();
            scanner.nextLine();
            
            switch(opt) {
                case 1: registerSupplier(scanner); break;
                case 2: listSuppliers(); break;
                case 3: registerInvoice(scanner); break;
                case 4: viewPendingInvoices(); break;
                case 5: registerPayment(scanner); break;
                case 6: detectCostIncrease(); break;
                case 7: suggestRetailPrice(scanner); break;
                case 8: compareMarketPrice(scanner); break;
                case 9: return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
    
    private static void registerSupplier(Scanner scanner) {
        System.out.print("ID del proveedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (findSupplierById(id) != null) {
            System.out.println("Ya existe un proveedor con ese ID");
            return;
        }
        
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Persona de contacto: ");
        String contact = scanner.nextLine();
        System.out.print("Telefono: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Direccion: ");
        String address = scanner.nextLine();
        System.out.print("Plazo de credito (dias): ");
        double creditTerm = scanner.nextDouble();
        System.out.print("Limite de credito: $");
        double creditLimit = scanner.nextDouble();
        
        Supplier s = new Supplier(id, name, contact, phone, email, address, creditTerm, creditLimit);
        suppliers.add(s);
        saveSuppliers();
        System.out.println("Proveedor registrado");
    }
    
    private static void listSuppliers() {
        if (suppliers.isEmpty()) {
            System.out.println("No hay proveedores registrados");
            return;
        }
        System.out.println("\nPROVEEDORES");
        for (Supplier s : suppliers) {
            System.out.println(s);
        }
    }
    
    private static void registerInvoice(Scanner scanner) {
        System.out.print("ID del proveedor: ");
        int supplierId = scanner.nextInt();
        scanner.nextLine();
        
        Supplier supplier = findSupplierById(supplierId);
        if (supplier == null) {
            System.out.println("Proveedor no encontrado");
            return;
        }
        
        System.out.print("Numero de factura: ");
        String invoiceNumber = scanner.nextLine();
        System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
        String dueDateStr = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateStr);
        
        int invoiceId = invoices.size() + 1;
        SupplierInvoice invoice = new SupplierInvoice(invoiceId, supplierId, invoiceNumber, dueDate);
        
        System.out.println("Agregar productos a la factura");
        while (true) {
            System.out.print("ID del producto (0 para terminar): ");
            int productId = scanner.nextInt();
            if (productId == 0) break;
            
            ProductManagement.Product product = ProductManagement.findById(productId);
            if (product == null) {
                System.out.println("Producto no encontrado");
                continue;
            }
            
            System.out.print("Cantidad: ");
            int quantity = scanner.nextInt();
            System.out.print("Costo unitario: $");
            double unitCost = scanner.nextDouble();
            
            InvoiceItem item = new InvoiceItem(productId, product.getName(), quantity, unitCost);
            invoice.addItem(item);
            
            priceHistory.computeIfAbsent(String.valueOf(productId), k -> new ArrayList<>()).add(unitCost);
            savePriceHistory();
            
            System.out.println("Producto agregado");
        }
        
        invoices.add(invoice);
        supplier.addInvoiceId(invoiceId);
        supplier.setCurrentDebt(supplier.getCurrentDebt() + invoice.getTotal());
        
        saveInvoices();
        saveSuppliers();
        
        System.out.printf("Factura registrada. Total: $%.2f\n", invoice.getTotal());
        checkForPriceIncrease(invoice);
    }
    
    private static void viewPendingInvoices() {
        System.out.println("\nFACTURAS PENDIENTES");
        boolean hasPending = false;
        
        for (SupplierInvoice inv : invoices) {
            if ("pending".equals(inv.getStatus())) {
                Supplier s = findSupplierById(inv.getSupplierId());
                String supplierName = (s != null) ? s.getName() : "Desconocido";
                System.out.printf("ID:%d | Proveedor:%s | Total:$%.2f | Vence:%s | %s\n",
                    inv.getInvoiceId(), supplierName, inv.getTotal(), inv.getDueDate(),
                    inv.isOverdue() ? "VENCIDA" : "Pendiente");
                hasPending = true;
            }
        }
        
        if (!hasPending) {
            System.out.println("No hay facturas pendientes");
        }
    }
    
    private static void registerPayment(Scanner scanner) {
        System.out.print("ID de la factura a pagar: ");
        int invoiceId = scanner.nextInt();
        
        SupplierInvoice invoice = findInvoiceById(invoiceId);
        if (invoice == null) {
            System.out.println("Factura no encontrada");
            return;
        }
        
        if (!"pending".equals(invoice.getStatus())) {
            System.out.println("Esta factura ya fue pagada");
            return;
        }
        
        invoice.setStatus("paid");
        Supplier supplier = findSupplierById(invoice.getSupplierId());
        if (supplier != null) {
            supplier.setCurrentDebt(supplier.getCurrentDebt() - invoice.getTotal());
        }
        
        saveInvoices();
        saveSuppliers();
        System.out.printf("Pago registrado. Total pagado: $%.2f\n", invoice.getTotal());
    }
    
    private static void detectCostIncrease() {
        System.out.println("\nDETECCION DE AUMENTO DE COSTOS");
        boolean found = false;
        
        for (Map.Entry<String, List<Double>> entry : priceHistory.entrySet()) {
            List<Double> prices = entry.getValue();
            if (prices.size() >= 2) {
                double lastPrice = prices.get(prices.size() - 1);
                double previousPrice = prices.get(prices.size() - 2);
                double increase = ((lastPrice - previousPrice) / previousPrice) * 100;
                
                if (increase > 5) {
                    ProductManagement.Product p = ProductManagement.findById(Integer.parseInt(entry.getKey()));
                    String productName = (p != null) ? p.getName() : "ID:" + entry.getKey();
                    System.out.printf("ALERTA: %s - Aumento del %.1f%% (de $%.2f a $%.2f)\n",
                        productName, increase, previousPrice, lastPrice);
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("No se detectaron aumentos significativos (>5%)");
        }
    }
    
    private static void suggestRetailPrice(Scanner scanner) {
        System.out.print("ID del producto: ");
        int productId = scanner.nextInt();
        
        ProductManagement.Product product = ProductManagement.findById(productId);
        if (product == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.print("Costo actual del producto: $");
        double currentCost = scanner.nextDouble();
        System.out.print("Margen de ganancia deseado (%): ");
        double margin = scanner.nextDouble();
        
        double suggestedPrice = currentCost * (1 + margin / 100);
        double currentProfit = (product.getRetailPrice() - currentCost) / currentCost * 100;
        
        System.out.println("\nSUGERENCIA DE PRECIO");
        System.out.println("Producto: " + product.getName());
        System.out.printf("Costo actual: $%.2f\n", currentCost);
        System.out.printf("Precio actual: $%.2f (Margen actual: %.1f%%)\n", 
            product.getRetailPrice(), currentProfit);
        System.out.printf("PRECIO SUGERIDO: $%.2f (Margen: %.0f%%)\n", suggestedPrice, margin);
        System.out.print("\nDesea actualizar el precio? (s/n): ");
        
        if (scanner.next().equalsIgnoreCase("s")) {
            product.setRetailPrice(suggestedPrice);
            ProductManagement.updateProductPrice(productId, suggestedPrice);
            System.out.println("Precio actualizado");
        }
    }
    
    private static void compareMarketPrice(Scanner scanner) {
        System.out.print("ID del producto: ");
        int productId = scanner.nextInt();
        
        ProductManagement.Product product = ProductManagement.findById(productId);
        if (product == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        List<Double> historicalPrices = priceHistory.get(String.valueOf(productId));
        if (historicalPrices == null || historicalPrices.isEmpty()) {
            System.out.println("No hay historial de precios para este producto");
            return;
        }
        
        double averagePrice = historicalPrices.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double lastPrice = historicalPrices.get(historicalPrices.size() - 1);
        double diffPercent = ((lastPrice - averagePrice) / averagePrice) * 100;
        
        System.out.println("\nCOMPARACION DE PRECIOS");
        System.out.println("Producto: " + product.getName());
        System.out.printf("Precio promedio historico: $%.2f\n", averagePrice);
        System.out.printf("Ultimo precio registrado: $%.2f\n", lastPrice);
        
        if (diffPercent > 10) {
            System.out.printf("ALERTA: El proveedor esta cobrando %.1f%% por encima del promedio\n", diffPercent);
        } else if (diffPercent < -10) {
            System.out.printf("El precio actual es %.1f%% menor al promedio\n", Math.abs(diffPercent));
        } else {
            System.out.println("El precio esta dentro del rango normal");
        }
    }
    
    private static void checkForPriceIncrease(SupplierInvoice invoice) {
        for (InvoiceItem item : invoice.getItems()) {
            List<Double> prices = priceHistory.get(String.valueOf(item.getProductId()));
            if (prices != null && prices.size() >= 2) {
                double lastPrice = prices.get(prices.size() - 1);
                double prevPrice = prices.get(prices.size() - 2);
                if (lastPrice > prevPrice) {
                    System.out.printf("El costo de '%s' aumento de $%.2f a $%.2f\n",
                        item.getProductName(), prevPrice, lastPrice);
                }
            }
        }
    }
    
    private static Supplier findSupplierById(int id) {
        return suppliers.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }
    
    private static SupplierInvoice findInvoiceById(int id) {
        return invoices.stream().filter(i -> i.getInvoiceId() == id).findFirst().orElse(null);
    }
    
    // METODO AGREGADO PARA OBTENER TODOS LOS PROVEEDORES
    public static List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers);
    }
    
    private static void loadSuppliers() {
        try {
            File file = new File(SUPPLIERS_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Supplier>>(){}.getType();
                List<Supplier> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    suppliers = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando proveedores: " + e.getMessage());
        }
    }
    
    private static void saveSuppliers() {
        try {
            String json = gson.toJson(suppliers);
            java.nio.file.Files.write(java.nio.file.Paths.get(SUPPLIERS_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando proveedores: " + e.getMessage());
        }
    }
    
    private static void loadInvoices() {
        try {
            File file = new File(INVOICES_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<SupplierInvoice>>(){}.getType();
                List<SupplierInvoice> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    invoices = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando facturas: " + e.getMessage());
        }
    }
    
    private static void saveInvoices() {
        try {
            String json = gson.toJson(invoices);
            java.nio.file.Files.write(java.nio.file.Paths.get(INVOICES_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando facturas: " + e.getMessage());
        }
    }
    
    private static void loadPriceHistory() {
        try {
            File file = new File(PRICE_HISTORY_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<Map<String, List<Double>>>(){}.getType();
                Map<String, List<Double>> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    priceHistory = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando historial de precios: " + e.getMessage());
        }
    }
    
    private static void savePriceHistory() {
        try {
            String json = gson.toJson(priceHistory);
            java.nio.file.Files.write(java.nio.file.Paths.get(PRICE_HISTORY_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando historial de precios: " + e.getMessage());
        }
    }
}