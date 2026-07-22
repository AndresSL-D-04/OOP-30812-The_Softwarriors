package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.CreditAccount;
import ec.edu.espe.safestore.model.Transaction;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adrian Vizcaino, The-Softwarriors, @ESPE
 */

public class CreditController {

    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;

    public CreditController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.collection = dbConnection.getCollection(Constants.COLLECTION_CREDITS);
    }

    public boolean addAccount(CreditAccount account) {
        if (account == null || findByCustomerId(account.getCustomerId()) != null) return false;
        collection.insertOne(DocumentConverter.creditAccountToDoc(account));
        return true;
    }

    public CreditAccount findByCustomerId(int customerId) {
        Document doc = collection.find(Filters.eq("customerId", customerId)).first();
        return doc != null ? DocumentConverter.docToCreditAccount(doc) : null;
    }

    public List<CreditAccount> getAllAccounts() {
        List<CreditAccount> accounts = new ArrayList<>();
        for (Document doc : collection.find()) {
            accounts.add(DocumentConverter.docToCreditAccount(doc));
        }
        return accounts;
    }

    private boolean saveAccount(CreditAccount account) {
        collection.replaceOne(
            Filters.eq("customerId", account.getCustomerId()),
            DocumentConverter.creditAccountToDoc(account),
            new ReplaceOptions().upsert(false)
        );
        return true;
    }

    public boolean addDebt(int customerId, double amount, String description) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null || account.isBlocked() || !ValidationUtil.isValidAmount(amount)) return false;
        if (account.getCurrentDebt() + amount > account.getCreditLimit()) return false;
        account.addTransaction(new Transaction(amount, description, Constants.TX_DEBT, new Date()));
        return saveAccount(account);
    }

    public boolean makePayment(int customerId, double amount, String description) {
        CreditAccount account = findByCustomerId(customerId);
        if (account == null || !ValidationUtil.isValidAmount(amount)) return false;
        if (amount > account.getCurrentDebt()) return false;
        account.addTransaction(new Transaction(amount, description, Constants.TX_PAYMENT, new Date()));
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
        return account != null ? account.getTransactions() : new ArrayList<>();
    }
}