package ec.edu.espe.safestore.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 *
 * @author ronald, The Softwarriors, @ESPE
 */
public class ComboSystem {
    private static final String COMBOS_FILE = "combos.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Combo> combos = new ArrayList<>();
    
    static {
        loadFromFile();
    }
    
    public static class Combo {
        private int id;
        private String name;
        private String description;
        private List<ComboItem> items;
        private double comboPrice;
        private boolean isActive;
        
        public Combo() {
            this.items = new ArrayList<>();
            this.isActive = true;
        }
        
        public Combo(int id, String name, String description, double comboPrice) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.comboPrice = comboPrice;
            this.items = new ArrayList<>();
            this.isActive = true;
        }
        
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public List<ComboItem> getItems() { return items; }
        public void setItems(List<ComboItem> items) { this.items = items; }
        public double getComboPrice() { return comboPrice; }
        public void setComboPrice(double comboPrice) { this.comboPrice = comboPrice; }
        public boolean isActive() { return isActive; }
        public void setActive(boolean active) { isActive = active; }
        
        public void addItem(ComboItem item) { items.add(item); }
        
        public double calculateIndividualPrice() {
            return items.stream().mapToDouble(i -> i.getProduct().getRetailPrice() * i.getQuantity()).sum();
        }
        
        public double getSavings() {
            return calculateIndividualPrice() - comboPrice;
        }
        
        @Override
        public String toString() {
            return String.format("ID:%d | %s | Precio:$%.2f | Ahorro:$%.2f | %s",
                id, name, comboPrice, getSavings(), isActive ? "Activo" : "Inactivo");
        }
    }
    
    public static class ComboItem {
        private int productId;
        private String productName;
        private double productPrice;
        private int quantity;
        
        public ComboItem() {}
        
        public ComboItem(ProductManagement.Product product, int quantity) {
            this.productId = product.getId();
            this.productName = product.getName();
            this.productPrice = product.getRetailPrice();
            this.quantity = quantity;
        }
        
        public int getProductId() { return productId; }
        public void setProductId(int productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public double getProductPrice() { return productPrice; }
        public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        
        public ProductManagement.Product getProduct() {
            return ProductManagement.findById(productId);
        }
    }
    
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nCOMBOS / PROMOCIONES");
            System.out.println("1. Crear combo");
            System.out.println("2. Listar combos");
            System.out.println("3. Activar combo");
            System.out.println("4. Desactivar combo");
            System.out.println("5. Agregar producto a combo");
            System.out.println("6. Ver detalle de combo");
            System.out.println("7. Volver");
            System.out.print("Opcion: ");
            int option = scanner.nextInt();
            
            switch(option) {
                case 1: createCombo(scanner); break;
                case 2: listCombos(); break;
                case 3: activateCombo(scanner); break;
                case 4: deactivateCombo(scanner); break;
                case 5: addProductToCombo(scanner); break;
                case 6: viewComboDetails(scanner); break;
                case 7: return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
    
    private static void createCombo(Scanner scanner) {
        System.out.print("ID del combo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (findComboById(id) != null) {
            System.out.println("Ya existe un combo con ese ID");
            return;
        }
        
        System.out.print("Nombre del combo: ");
        String name = scanner.nextLine();
        System.out.print("Descripcion: ");
        String desc = scanner.nextLine();
        System.out.print("Precio del combo: $");
        double price = scanner.nextDouble();
        
        Combo combo = new Combo(id, name, desc, price);
        combos.add(combo);
        saveToFile();
        System.out.println("Combo creado");
    }
    
    private static void listCombos() {
        if (combos.isEmpty()) {
            System.out.println("No hay combos registrados");
            return;
        }
        System.out.println("\nLISTA DE COMBOS");
        for (Combo c : combos) {
            System.out.println(c);
        }
    }
    
    private static void activateCombo(Scanner scanner) {
        System.out.print("ID del combo a activar: ");
        int id = scanner.nextInt();
        Combo combo = findComboById(id);
        if (combo == null) {
            System.out.println("Combo no encontrado");
            return;
        }
        combo.setActive(true);
        saveToFile();
        System.out.println("Combo activado");
    }
    
    private static void deactivateCombo(Scanner scanner) {
        System.out.print("ID del combo a desactivar: ");
        int id = scanner.nextInt();
        Combo combo = findComboById(id);
        if (combo == null) {
            System.out.println("Combo no encontrado");
            return;
        }
        combo.setActive(false);
        saveToFile();
        System.out.println("Combo desactivado");
    }
    
    private static void addProductToCombo(Scanner scanner) {
        System.out.print("ID del combo: ");
        int comboId = scanner.nextInt();
        Combo combo = findComboById(comboId);
        if (combo == null) {
            System.out.println("Combo no encontrado");
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
        
        ComboItem item = new ComboItem(product, quantity);
        combo.addItem(item);
        saveToFile();
        
        double individualTotal = combo.calculateIndividualPrice();
        System.out.printf("Producto agregado. Precio individual total: $%.2f | Combo: $%.2f | Ahorro: $%.2f\n",
            individualTotal, combo.getComboPrice(), combo.getSavings());
    }
    
    private static void viewComboDetails(Scanner scanner) {
        System.out.print("ID del combo: ");
        int id = scanner.nextInt();
        Combo combo = findComboById(id);
        if (combo == null) {
            System.out.println("Combo no encontrado");
            return;
        }
        
        System.out.println("\nDETALLE DEL COMBO");
        System.out.println("Nombre: " + combo.getName());
        System.out.println("Descripcion: " + combo.getDescription());
        System.out.println("Precio combo: $" + combo.getComboPrice());
        System.out.println("Productos:");
        if (combo.getItems().isEmpty()) {
            System.out.println("  No hay productos en este combo");
        } else {
            for (ComboItem item : combo.getItems()) {
                System.out.printf("  %s x%d = $%.2f\n", 
                    item.getProductName(), item.getQuantity(), 
                    item.getProductPrice() * item.getQuantity());
            }
        }
        System.out.printf("Precio individual total: $%.2f\n", combo.calculateIndividualPrice());
        System.out.printf("AHORRO: $%.2f\n", combo.getSavings());
        
        if (combo.getSavings() <= 0) {
            System.out.println("ADVERTENCIA: El combo no genera ahorro. Revise los precios.");
        }
    }
    
    private static Combo findComboById(int id) {
        return combos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
    
    // METODO AGREGADO PARA OBTENER TODOS LOS COMBOS
    public static List<Combo> getAllCombos() {
        return new ArrayList<>(combos);
    }
    
    private static void loadFromFile() {
        try {
            File file = new File(COMBOS_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Combo>>(){}.getType();
                List<Combo> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    combos = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando combos: " + e.getMessage());
        }
    }
    
    private static void saveToFile() {
        try {
            String json = gson.toJson(combos);
            java.nio.file.Files.write(java.nio.file.Paths.get(COMBOS_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando combos: " + e.getMessage());
        }
    }
}