
package ec.edu.espe.safestore.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class MongoDBConnection {
    
    private static final String CONNECTION_STRING = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "safeStoreDB";
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;
    
    public static void connect() {
        try {
            if (mongoClient == null) {
                mongoClient = MongoClients.create(CONNECTION_STRING);
                database = mongoClient.getDatabase(DATABASE_NAME);
                System.out.println("Conectado a MongoDB Atlas");
            }
        } catch (Exception e) {
            System.out.println("Error conectando a MongoDB: " + e.getMessage());
        }
    }
    
    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }
    
    public static MongoCollection<Document> getCollection(String collectionName) {
        return getDatabase().getCollection(collectionName);
    }
    
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
            System.out.println("Conexion a MongoDB cerrada");
        }
    }
    
    public static boolean isConnected() {
        return mongoClient != null && database != null;
    }
}
