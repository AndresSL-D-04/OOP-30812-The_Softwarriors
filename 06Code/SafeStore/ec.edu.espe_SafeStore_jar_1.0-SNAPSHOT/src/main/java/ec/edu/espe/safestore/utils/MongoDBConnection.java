package ec.edu.espe.safestore.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class MongoDBConnection {
    
    private static final String CONNECTION_STRING = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "safestore";
    private MongoClient mongoClient;
    private MongoDatabase database;
    private boolean connected;
    
    public boolean connect() {
        try {
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                    .applyToSocketSettings(builder -> builder.connectTimeout(30, TimeUnit.SECONDS))
                    .build();
            
            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(DATABASE_NAME);
            database.runCommand(new Document("ping", 1));
            connected = true;
            System.out.println("Conectado a MongoDB Atlas");
            return true;
        } catch (Exception e) {
            System.out.println("Error conectando a MongoDB: " + e.getMessage());
            connected = false;
            return false;
        }
    }
    
    public MongoDatabase getDatabase() {
        return database;
    }
    
    public MongoCollection<Document> getCollection(String collectionName) {
        if (!connected) {
            connect();
        }
        return database.getCollection(collectionName);
    }
    
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            connected = false;
            System.out.println("Conexión cerrada");
        }
    }
    
    public boolean isConnected() {
        return connected && mongoClient != null && database != null;
    }
}