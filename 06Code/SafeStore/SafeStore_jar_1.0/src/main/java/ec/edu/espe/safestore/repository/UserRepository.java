
package ec.edu.espe.safestore.repository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.safestore.model.User;
import ec.edu.espe.safestore.repository.interfaces.IUserRepository;
import ec.edu.espe.safestore.utils.Constants;
import ec.edu.espe.safestore.utils.DocumentConverter;
import ec.edu.espe.safestore.utils.MongoDBConnection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class UserRepository implements IUserRepository {
    
    private final MongoDBConnection dbConnection;
    private final MongoCollection<Document> collection;
    
    public UserRepository(MongoDBConnection dbConnection) {
        this.dbConnection = dbConnection;
        this.collection = dbConnection.getCollection(Constants.COLLECTION_USERS);
    }
    
    @Override
    public User findByUsername(String username) {
        Document doc = collection.find(
            Filters.regex("username", "(?i)^" + username + "$")
        ).first();
        return doc != null ? DocumentConverter.docToUser(doc) : null;
    }
    
    @Override
    public User findByEmail(String email) {
        Document doc = collection.find(
            Filters.regex("email", "(?i)^" + email + "$")
        ).first();
        return doc != null ? DocumentConverter.docToUser(doc) : null;
    }
    
    @Override
    public User findByResetToken(String token) {
        Document doc = collection.find(
            Filters.eq("resetToken", token)
        ).first();
        return doc != null ? DocumentConverter.docToUser(doc) : null;
    }
    
    @Override
    public boolean save(User user) {
        collection.insertOne(DocumentConverter.userToDoc(user));
        return true;
    }
    
    @Override
    public boolean update(User user) {
        collection.replaceOne(
            Filters.eq("username", user.getUsername()),
            DocumentConverter.userToDoc(user),
            new ReplaceOptions().upsert(false)
        );
        return true;
    }
    
    @Override
    public boolean delete(String username) {
        collection.deleteOne(Filters.eq("username", username));
        return true;
    }
    
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (Document doc : collection.find()) {
            users.add(DocumentConverter.docToUser(doc));
        }
        return users;
    }
    
    @Override
    public List<User> findByRole(String role) {
        List<User> users = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("role", role))) {
            users.add(DocumentConverter.docToUser(doc));
        }
        return users;
    }
}
