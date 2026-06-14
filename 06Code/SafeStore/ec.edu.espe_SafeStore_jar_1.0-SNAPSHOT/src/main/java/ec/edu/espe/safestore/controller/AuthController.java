
package ec.edu.espe.safestore.controller;

/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 *
 */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.safestore.model.User;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class AuthController {

    private MongoDBConnection dbConnection;
    private MongoCollection<Document> collection;

    public AuthController() {
        dbConnection = new MongoDBConnection();
        dbConnection.connect();
        collection = dbConnection.getCollection("users");
        loadDefaultUsers();
    }

    private void loadDefaultUsers() {
        
        if (collection.countDocuments() == 0) {
            List<User> defaults = List.of(
                new User("gerente", "1234", "Manager"),
                new User("admin", "admin", "Manager"),
                new User("cajero1", "1234", "Cashier"),
                new User("cajero", "cajero", "Cashier")
            );
            for (User u : defaults) {
                collection.insertOne(userToDoc(u));
            }
        }
    }

    private Document userToDoc(User u) {
        return new Document("username", u.getUsername())
                .append("password", u.getPassword())
                .append("role", u.getRole());
    }

    private User docToUser(Document doc) {
        return new User(
            doc.getString("username"),
            doc.getString("password"),
            doc.getString("role")
        );
    }

    public boolean authenticate(String username, String password, String role) {
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
        Document existing = collection.find(
            Filters.regex("username", "(?i)^" + username + "$")
        ).first();
        if (existing != null) return false;
        collection.insertOne(new Document("username", username)
                .append("password", password)
                .append("role", role));
        return true;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (Document doc : collection.find()) {
            users.add(docToUser(doc));
        }
        return users;
    }
}