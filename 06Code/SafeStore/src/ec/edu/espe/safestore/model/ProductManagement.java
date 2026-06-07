/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
    public class ProductManagement {
    private static final String FILE_NAME = "products.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<Product> products = new ArrayList<>();
    
    static {
        loadFromFile();
    }
    
    public static class Product {
        private int id;
        private String name;
        private double wholesalePrice;
        private double retailPrice;
        private int stock;
        private int minStock;
        private String expiryDate;
        
        public Product() {}
        
        public Product(int id, String name, double wholesalePrice, double retailPrice, int stock, int minStock, String expiryDate) {
            this.id = id;
            this.name = name;
            this.wholesalePrice = wholesalePrice;
            this.retailPrice = retailPrice;
            this.stock = stock;
            this.minStock = minStock;
            this.expiryDate = expiryDate;
        }
        
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public double getWholesalePrice() { return wholesalePrice; }
        public void setWholesalePrice(double wholesalePrice) { this.wholesalePrice = wholesalePrice; }
        public double getRetailPrice() { return retailPrice; }
        public void setRetailPrice(double retailPrice) { this.retailPrice = retailPrice; }
        public int getStock() { return stock; }
        public void setStock(int stock) { this.stock = stock; }
        public int getMinStock() { return minStock; }
        public void setMinStock(int minStock) { this.minStock = minStock; }
        public String getExpiryDate() { return expiryDate; }
        public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
        
        public double getPriceByQuantity(int quantity) {
            return (quantity >= 12) ? wholesalePrice : retailPrice;
        }
        
        @Override
        public String toString() {
            return String.format("ID:%d | %s | Stock:%d | Menor:$%.2f | Mayor:$%.2f | Vence:%s",
                                 id, name, stock, retailPrice, wholesalePrice, expiryDate);
        }
    }
    
    public static void addProduct(Product product) {
        products.add(product);
        saveToFile();
    }
    
    public static void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
        saveToFile();
    }
    
    public static void saveToFile() {
        try {
            String json = gson.toJson(products);
            java.nio.file.Files.write(java.nio.file.Paths.get(FILE_NAME), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando productos: " + e.getMessage());
        }
    }
    
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nREGISTRO DE PRODUCTOS");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Actualizar stock");
            System.out.println("7. Productos con stock bajo");
            System.out.println("8. Volver");
            System.out.print("Opcion: ");
            
            int opt = scanner.nextInt();
            scanner.nextLine();
            
            switch(opt) {
                case 1: addProductFromScanner(scanner); break;
                case 2: listProducts(); break;
                case 3: searchProduct(scanner); break;
                case 4: updateProduct(scanner); break;
                case 5: deleteProductFromScanner(scanner); break;
                case 6: updateStock(scanner); break;
                case 7: showLowStock(); break;
                case 8: return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
    
    private static void addProductFromScanner(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (findById(id) != null) {
            System.out.println("Ya existe un producto con ese ID");
            return;
        }
        
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Precio mayor (12+ uds): $");
        double wholesale = scanner.nextDouble();
        System.out.print("Precio menor: $");
        double retail = scanner.nextDouble();
        System.out.print("Stock inicial: ");
        int stock = scanner.nextInt();
        System.out.print("Stock minimo: ");
        int minStock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha caducidad (YYYY-MM-DD): ");
        String expiry = scanner.nextLine();
        
        Product p = new Product(id, name, wholesale, retail, stock, minStock, expiry);
        addProduct(p);
        System.out.println("Producto agregado");
    }
    
    private static void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No hay productos registrados");
            return;
        }
        System.out.println("\nLISTA DE PRODUCTOS");
        for (Product p : products) {
            System.out.println(p);
        }
    }
    
    private static void searchProduct(Scanner scanner) {
        System.out.print("Buscar por ID o nombre: ");
        String query = scanner.nextLine();
        
        try {
            int id = Integer.parseInt(query);
            Product p = findById(id);
            if (p != null) {
                System.out.println("\nProducto encontrado:");
                System.out.println("ID: " + p.getId());
                System.out.println("Nombre: " + p.getName());
                System.out.println("Precio menor: $" + p.getRetailPrice());
                System.out.println("Precio mayor: $" + p.getWholesalePrice());
                System.out.println("Stock: " + p.getStock());
                System.out.println("Stock minimo: " + p.getMinStock());
                System.out.println("Caducidad: " + p.getExpiryDate());
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (NumberFormatException e) {
            boolean found = false;
            for (Product p : products) {
                if (p.getName().toLowerCase().contains(query.toLowerCase())) {
                    System.out.println(p);
                    found = true;
                }
            }
            if (!found) System.out.println("No se encontraron productos");
        }
    }
    
    private static void updateProduct(Scanner scanner) {
        System.out.print("ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Product p = findById(id);
        if (p == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.print("Nuevo nombre (" + p.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) p.setName(name);
        
        System.out.print("Nuevo precio menor ($" + p.getRetailPrice() + "): ");
        String retail = scanner.nextLine();
        if (!retail.isEmpty()) p.setRetailPrice(Double.parseDouble(retail));
        
        System.out.print("Nuevo precio mayor ($" + p.getWholesalePrice() + "): ");
        String wholesale = scanner.nextLine();
        if (!wholesale.isEmpty()) p.setWholesalePrice(Double.parseDouble(wholesale));
        
        saveToFile();
        System.out.println("Producto actualizado");
    }
    
    private static void deleteProductFromScanner(Scanner scanner) {
        System.out.print("ID del producto a eliminar: ");
        int id = scanner.nextInt();
        
        Product p = findById(id);
        if (p == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        deleteProduct(id);
        System.out.println("Producto eliminado");
    }
    
    private static void updateStock(Scanner scanner) {
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        
        Product p = findById(id);
        if (p == null) {
            System.out.println("Producto no encontrado");
            return;
        }
        
        System.out.print("Nuevo stock (actual: " + p.getStock() + "): ");
        int newStock = scanner.nextInt();
        p.setStock(newStock);
        saveToFile();
        
        if (newStock <= p.getMinStock()) {
            System.out.println("ALERTA: Stock por debajo del minimo!");
        }
        System.out.println("Stock actualizado");
    }
    
    private static void showLowStock() {
        boolean hasLow = false;
        System.out.println("\nPRODUCTOS CON STOCK BAJO");
        for (Product p : products) {
            if (p.getStock() <= p.getMinStock()) {
                System.out.printf("%s - Stock: %d (Minimo: %d)\n", p.getName(), p.getStock(), p.getMinStock());
                hasLow = true;
            }
        }
        if (!hasLow) System.out.println("Todos los productos tienen stock adecuado");
    }
    
    public static Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    
    public static void updateProductStock(int id, int newStock) {
        Product p = findById(id);
        if (p != null) {
            p.setStock(newStock);
            saveToFile();
        }
    }
    
    public static void updateProductMinStock(int id, int newMinStock) {
        Product p = findById(id);
        if (p != null) {
            p.setMinStock(newMinStock);
            saveToFile();
        }
    }
    
    public static void updateProductPrice(int id, double newPrice) {
        Product p = findById(id);
        if (p != null) {
            p.setRetailPrice(newPrice);
            saveToFile();
        }
    }
    
    public static List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    private static void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<Product>>(){}.getType();
                List<Product> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    products = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando productos: " + e.getMessage());
        }
    }
}

