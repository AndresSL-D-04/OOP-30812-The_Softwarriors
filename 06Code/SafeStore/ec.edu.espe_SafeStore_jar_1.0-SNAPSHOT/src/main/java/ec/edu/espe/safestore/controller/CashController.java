package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CashController {
    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;
    private double currentBalance;
    private boolean isOpen;
    private int currentSessionId;
    
    public CashController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("cash_sessions");
        
        if (collection.countDocuments() == 0) {
            Document sample = new Document("sessionId", 1)
                    .append("openDate", LocalDateTime.now().toString())
                    .append("closeDate", LocalDateTime.now().plusHours(8).toString())
                    .append("initialBalance", 500.0)
                    .append("finalBalance", 1250.0)
                    .append("expectedBalance", 1250.0)
                    .append("difference", 0.0)
                    .append("isOpen", false)
                    .append("transactions", new ArrayList<Document>());
            collection.insertOne(sample);
            System.out.println("Coleccion cash_sessions creada con datos de ejemplo");
        }
        
        loadCurrentSession();
    }
    
    private void loadCurrentSession() {
        Document doc = collection.find(Filters.eq("isOpen", true)).first();
        if (doc != null) {
            Object balanceObj = doc.get("expectedBalance");
            if (balanceObj instanceof Number) {
                this.currentBalance = ((Number) balanceObj).doubleValue();
            }
            this.isOpen = true;
            Object sessionIdObj = doc.get("sessionId");
            if (sessionIdObj instanceof Number) {
                this.currentSessionId = ((Number) sessionIdObj).intValue();
            }
        } else {
            this.currentBalance = 0;
            this.isOpen = false;
            this.currentSessionId = -1;
        }
    }
    
    public boolean openCash(double initialAmount) {
        if (initialAmount < 0) return false;
        if (isOpen) return false;
        
        currentBalance = initialAmount;
        isOpen = true;
        currentSessionId = (int) (System.currentTimeMillis() % 10000);
        
        Document doc = new Document("sessionId", currentSessionId)
                .append("openDate", LocalDateTime.now().toString())
                .append("initialBalance", initialAmount)
                .append("expectedBalance", currentBalance)
                .append("isOpen", true)
                .append("transactions", new ArrayList<Document>());
        collection.insertOne(doc);
        return true;
    }
    
    public boolean closeCash(double physicalCount) {
        if (!isOpen) return false;
        
        double difference = physicalCount - currentBalance;
        Document doc = collection.find(Filters.eq("sessionId", currentSessionId)).first();
        if (doc != null) {
            doc.put("closeDate", LocalDateTime.now().toString());
            doc.put("finalBalance", physicalCount);
            doc.put("difference", difference);
            doc.put("isOpen", false);
            collection.replaceOne(Filters.eq("sessionId", currentSessionId), doc);
        }
        
        isOpen = false;
        currentBalance = 0;
        return true;
    }
    
    public double calculateDifference(double physicalCount) {
        return physicalCount - currentBalance;
    }
    
    public boolean addIncome(double amount, String description) {
        if (!isOpen || amount < 0) return false;
        
        currentBalance += amount;
        addTransaction(amount, "INCOME", description);
        return true;
    }
    
    public boolean addExpense(double amount, String description) {
        if (!isOpen || amount < 0 || amount > currentBalance) return false;
        
        currentBalance -= amount;
        addTransaction(amount, "EXPENSE", description);
        return true;
    }
    
    private void addTransaction(double amount, String type, String description) {
        Document doc = collection.find(Filters.eq("sessionId", currentSessionId)).first();
        if (doc != null) {
            List<Document> transactions = doc.getList("transactions", Document.class);
            if (transactions == null) transactions = new ArrayList<>();
            
            Document tx = new Document("amount", amount)
                    .append("type", type)
                    .append("description", description)
                    .append("date", LocalDateTime.now().toString());
            transactions.add(tx);
            
            doc.put("transactions", transactions);
            doc.put("expectedBalance", currentBalance);
            collection.replaceOne(Filters.eq("sessionId", currentSessionId), doc);
        }
    }
    
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public List<Document> getAllSessions() {
        List<Document> sessions = new ArrayList<>();
        for (Document doc : collection.find()) {
            sessions.add(doc);
        }
        return sessions;
    }
}