
package ec.edu.espe.safestore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.safestore.model.User;
import ec.edu.espe.safestore.utils.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */
public class AuthController {

    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;
    private final DataInitializer dataInitializer;

    public AuthController() {
        this.dbConnection = new MongoDBConnection();
        this.dbConnection.connect();
        this.collection = dbConnection.getCollection(Constants.COLLECTION_USERS);
        this.dataInitializer = new DataInitializer(dbConnection);
        this.dataInitializer.initializeDefaultUsers();
    }

    public boolean authenticate(String username, String password, String role) {
        if (!ValidationUtil.isValidUsername(username) || !ValidationUtil.isValidPassword(password)) {
            return false;
        }
        Document doc = collection.find(
            Filters.and(
                Filters.regex("username", "(?i)^" + username + "$"),
                Filters.eq("password", password),
                Filters.eq("role", role)
            )
        ).first();
        return doc != null;
    }

    public boolean addUser(String username, String password, String role) {
        if (!ValidationUtil.isValidUsername(username) || !ValidationUtil.isValidPassword(password)) {
            return false;
        }
        Document existing = collection.find(
            Filters.regex("username", "(?i)^" + username + "$")
        ).first();
        if (existing != null) return false;
        collection.insertOne(DocumentConverter.userToDoc(new User(username, password, role)));
        return true;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (Document doc : collection.find()) {
            users.add(DocumentConverter.docToUser(doc));
        }
        return users;
    }
}