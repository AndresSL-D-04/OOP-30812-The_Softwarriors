package ec.edu.espe.safestore.controller;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.CreditAccount;
import ec.edu.espe.safestore.model.Transaction;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditController {

    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;

    public CreditController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("credits");
    }

    private Document accountToDoc(CreditAccount a) {
        List<Document> txDocs = new ArrayList<>();
        for (Transaction t : a.getTransactions()) {
            txDocs.add(new Document("amount", t.getAmount())
                    .append("description", t.getDescription())
                    .append("type", t.getType())
                    .append("date", t.getDate()));
        }
        return new Document("customerId", a.getCustomerId())
                .append("customerName", a.getCustomerName())
                .append("creditLimit", a.getCreditLimit())
                .append("currentDebt", a.getCurrentDebt())
                .append("isBlocked", a.isBlocked())
                .append("transactions", txDocs);
    }

    private CreditAccount docToAccount(Document doc) {
        CreditAccount a = new CreditAccount(
            doc.getInteger("customerId"),
            doc.getString("customerName"),
            doc.getDouble("creditLimit") != null ? doc.getDouble("creditLimit") : 0.0
        );
        a.setCurrentDebt(doc.getDouble("currentDebt") != null ? doc.getDouble("currentDebt") : 0.0);
        a.setBlocked(Boolean.TRUE.equals(doc.getBoolean("isBlocked")));
        List<Document> txDocs = doc.getList("transactions", Document.class);
        if (txDocs != null) {
            List<Transaction> txs = new ArrayList<>();
            for (Document txDoc : txDocs) {
                txs.add(new Transaction(
                    txDoc.getDouble("amount") != null ? txDoc.getDouble("amount") : 0.0,
                    txDoc.getString("description"),
                    txDoc.getString("type"),
                    txDoc.getDate("date") != null ? txDoc.getDate("date") : new Date()
                ));
            }
            a.setTransactions(txs);
        }
        return a;
    }

    public boolean addAccount(CreditAccount account) {
        if (findByCustomerId(account.getCustomerId()) != null) return false;
        collection.insertOne(accountToDoc(account));
        return true;
    }

    public CreditAccount findByCustomerId(int customerId) {
        Document doc = collection.find(Filters.eq("customerId", customerId)).first();
        return doc != null ? docToAccount(doc) : null;
    }

    public List<CreditAccount> getAllAccounts() {
        List<CreditAccount> accounts = new ArrayList<>();
        for (Document doc : collection.find()) accounts.add(docToAccount(doc));
        return accounts;
    }

    private boolean saveAccount(CreditAccount account) {
        collection.replaceOne(
            Filters.eq("customerId", account.getCustomerId()),
            accountToDoc(account),
            new ReplaceOptions().upsert(false)
        );
        return true;
    }

    public boolean addDebt(int customerId, double amount, String description) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null || account.isBlocked()) return false;
        if (account.getCurrentDebt() + amount > account.getCreditLimit()) return false;
        account.addTransaction(new Transaction(amount, description, "DEBT", new Date()));
        return saveAccount(account);
    }

    public boolean makePayment(int customerId, double amount, String description) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) return false;
        if (amount > account.getCurrentDebt()) return false;
        account.addTransaction(new Transaction(amount, description, "PAYMENT", new Date()));
        return saveAccount(account);
    }

    public boolean blockAccount(int customerId) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) return false;
        account.setBlocked(true);
        return saveAccount(account);
    }

    public boolean unblockAccount(int customerId) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) return false;
        account.setBlocked(false);
        return saveAccount(account);
    }

    public List<Transaction> getTransactions(int customerId) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null) return new ArrayList<>();
        return account.getTransactions();
    }
}