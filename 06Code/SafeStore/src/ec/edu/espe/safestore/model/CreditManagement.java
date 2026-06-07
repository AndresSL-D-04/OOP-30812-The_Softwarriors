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
public class CreditManagement {
    private static final String CREDITS_FILE = "credits.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<CreditAccount> accounts = new ArrayList<>();
    
    static {
        loadFromFile();
    }
    
    public static class CreditAccount {
        private int customerId;
        private String customerName;
        private double creditLimit;
        private double currentDebt;
        private List<Transaction> transactions;
        private boolean isBlocked;
        
        public CreditAccount() {
            this.transactions = new ArrayList<>();
            this.isBlocked = false;
        }
        
        public CreditAccount(int customerId, String customerName, double creditLimit) {
            this.customerId = customerId;
            this.customerName = customerName;
            this.creditLimit = creditLimit;
            this.currentDebt = 0;
            this.transactions = new ArrayList<>();
            this.isBlocked = false;
        }
        
        public int getCustomerId() { return customerId; }
        public void setCustomerId(int customerId) { this.customerId = customerId; }
        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }
        public double getCreditLimit() { return creditLimit; }
        public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
        public double getCurrentDebt() { return currentDebt; }
        public void setCurrentDebt(double currentDebt) { this.currentDebt = currentDebt; }
        public List<Transaction> getTransactions() { return transactions; }
        public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
        public boolean isBlocked() { return isBlocked; }
        public void setBlocked(boolean blocked) { isBlocked = blocked; }
        
        public boolean addDebt(double amount, String description) {
            if (isBlocked) {
                System.out.println("Cuenta bloqueada. No se puede agregar deuda.");
                return false;
            }
            if (currentDebt + amount > creditLimit) {
                System.out.printf("Limite de credito excedido. Limite: $%.2f, Deuda actual: $%.2f\n", creditLimit, currentDebt);
                return false;
            }
            currentDebt += amount;
            transactions.add(new Transaction(amount, description, "DEUDA", new Date()));
            System.out.printf("Deuda agregada: $%.2f (%s). Nueva deuda: $%.2f\n", amount, description, currentDebt);
            return true;
        }
        
        public boolean makePayment(double amount, String description) {
            if (amount > currentDebt) {
                System.out.println("El pago excede la deuda actual");
                return false;
            }
            currentDebt -= amount;
            transactions.add(new Transaction(amount, description, "PAGO", new Date()));
            System.out.printf("Pago registrado: $%.2f (%s). Deuda restante: $%.2f\n", amount, description, currentDebt);
            return true;
        }
        
        @Override
        public String toString() {
            return String.format("ID:%d | %s | Limite:$%.2f | Deuda:$%.2f | %s",
                customerId, customerName, creditLimit, currentDebt, isBlocked ? "BLOQUEADO" : "Activo");
        }
    }
    
    public static class Transaction {
        private double amount;
        private String description;
        private String type;
        private Date date;
        
        public Transaction() {}
        
        public Transaction(double amount, String description, String type, Date date) {
            this.amount = amount;
            this.description = description;
            this.type = type;
            this.date = date;
        }
        
        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public Date getDate() { return date; }
        public void setDate(Date date) { this.date = date; }
        
        @Override
        public String toString() {
            return String.format("%s | %s | $%.2f | %s", date, type, amount, description);
        }
    }
    
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nGESTION DE CREDITOS");
            System.out.println("1. Crear cuenta de credito");
            System.out.println("2. Agregar deuda");
            System.out.println("3. Realizar pago");
            System.out.println("4. Verificar limite");
            System.out.println("5. Bloquear cuenta");
            System.out.println("6. Desbloquear cuenta");
            System.out.println("7. Ver historial de transacciones");
            System.out.println("8. Listar todas las cuentas");
            System.out.println("9. Volver");
            System.out.print("Opcion: ");
            int option = scanner.nextInt();
            
            switch(option) {
                case 1: createAccount(scanner); break;
                case 2: addDebt(scanner); break;
                case 3: makePayment(scanner); break;
                case 4: checkLimit(scanner); break;
                case 5: blockAccount(scanner); break;
                case 6: unblockAccount(scanner); break;
                case 7: viewTransactions(scanner); break;
                case 8: listAccounts(); break;
                case 9: return;
                default: System.out.println("Opcion invalida");
            }
        }
    }
    
    private static void createAccount(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del cliente: ");
        String name = scanner.nextLine();
        System.out.print("Limite de credito: $");
        double limit = scanner.nextDouble();
        
        CreditAccount account = new CreditAccount(id, name, limit);
        accounts.add(account);
        saveToFile();
        System.out.println("Cuenta de credito creada");
    }
    
    private static void addDebt(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        CreditAccount account = findAccountById(id);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }
        System.out.print("Monto de la deuda: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descripcion: ");
        String desc = scanner.nextLine();
        if (account.addDebt(amount, desc)) {
            saveToFile();
        }
    }
    
    private static void makePayment(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        CreditAccount account = findAccountById(id);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }
        System.out.print("Monto del pago: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descripcion: ");
        String desc = scanner.nextLine();
        if (account.makePayment(amount, desc)) {
            saveToFile();
        }
    }
    
    private static void checkLimit(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        CreditAccount account = findAccountById(id);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }
        System.out.printf("Cliente: %s\n", account.getCustomerName());
        System.out.printf("Limite de credito: $%.2f\n", account.getCreditLimit());
        System.out.printf("Deuda actual: $%.2f\n", account.getCurrentDebt());
        System.out.printf("Credito disponible: $%.2f\n", account.getCreditLimit() - account.getCurrentDebt());
    }
    
    private static void blockAccount(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        CreditAccount account = findAccountById(id);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }
        account.setBlocked(true);
        saveToFile();
        System.out.println("Cuenta bloqueada");
    }
    
    private static void unblockAccount(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        CreditAccount account = findAccountById(id);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }
        account.setBlocked(false);
        saveToFile();
        System.out.println("Cuenta desbloqueada");
    }
    
    private static void viewTransactions(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        CreditAccount account = findAccountById(id);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
            return;
        }
        System.out.println("\nHISTORIAL DE TRANSACCIONES");
        if (account.getTransactions().isEmpty()) {
            System.out.println("No hay transacciones registradas");
            return;
        }
        for (Transaction t : account.getTransactions()) {
            System.out.println(t);
        }
    }
    
    private static void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No hay cuentas de credito registradas");
            return;
        }
        System.out.println("\nCUENTAS DE CREDITO");
        for (CreditAccount a : accounts) {
            System.out.println(a);
        }
    }
    
    private static CreditAccount findAccountById(int id) {
        return accounts.stream().filter(a -> a.getCustomerId() == id).findFirst().orElse(null);
    }
    
    // METODO AGREGADO PARA OBTENER TODAS LAS CUENTAS
    public static List<CreditAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
    
    private static void loadFromFile() {
        try {
            File file = new File(CREDITS_FILE);
            if (file.exists()) {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Type type = new TypeToken<ArrayList<CreditAccount>>(){}.getType();
                List<CreditAccount> loaded = gson.fromJson(content, type);
                if (loaded != null) {
                    accounts = loaded;
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando creditos: " + e.getMessage());
        }
    }
    
    private static void saveToFile() {
        try {
            String json = gson.toJson(accounts);
            java.nio.file.Files.write(java.nio.file.Paths.get(CREDITS_FILE), json.getBytes());
        } catch (Exception e) {
            System.out.println("Error guardando creditos: " + e.getMessage());
        }
    }
}