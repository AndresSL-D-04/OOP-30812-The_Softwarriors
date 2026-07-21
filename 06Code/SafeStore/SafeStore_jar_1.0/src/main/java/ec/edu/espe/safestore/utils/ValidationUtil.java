
package ec.edu.espe.safestore.utils;

import ec.edu.espe.safestore.model.Product;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
public class ValidationUtil {
    
    private static final double MAX_PRICE = 999999.99;
    private static final int MAX_STOCK = 999999;
    private static final int MAX_MIN_STOCK = 99999;
    
    public static boolean isValidId(int id) {
        return id > 0;
    }
    
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 100;
    }
    
    public static boolean isValidPrice(double price) {
        return price >= 0 && price <= MAX_PRICE;
    }
    
    public static boolean isValidStock(int stock) {
        return stock >= 0 && stock <= MAX_STOCK;
    }
    
    public static boolean isValidMinStock(int minStock) {
        return minStock >= 0 && minStock <= MAX_MIN_STOCK;
    }
    
    public static boolean isValidProduct(Product p) {
        return isValidId(p.getId()) && 
               isValidName(p.getName()) && 
               isValidPrice(p.getWholesalePrice()) && 
               isValidPrice(p.getRetailPrice()) && 
               isValidStock(p.getStock()) && 
               isValidMinStock(p.getMinStock());
    }
    
    public static boolean isValidPassword(String password) {
        return password != null && !password.trim().isEmpty() && password.length() >= 4;
    }
    
    public static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty() && username.length() <= 50;
    }
    
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{7,15}");
    }
    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean isValidAmount(double amount) {
        return amount > 0 && amount <= MAX_PRICE;
    }
}