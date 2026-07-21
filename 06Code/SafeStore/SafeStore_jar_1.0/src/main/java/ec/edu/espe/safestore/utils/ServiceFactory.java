
package ec.edu.espe.safestore.utils;
import ec.edu.espe.safestore.controller.AuthController;
import ec.edu.espe.safestore.controller.interfaces.IAuthController;
import ec.edu.espe.safestore.repository.UserRepository;
import ec.edu.espe.safestore.repository.interfaces.IUserRepository;
import ec.edu.espe.safestore.service.AuthService;
import ec.edu.espe.safestore.service.interfaces.IAuthService;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class ServiceFactory {
    
    private static MongoDBConnection dbConnection;
    private static IUserRepository userRepository;
    private static IAuthService authService;
    private static IAuthController authController;
    
    public static MongoDBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new MongoDBConnection();
            dbConnection.connect();
        }
        return dbConnection;
    }
    
    public static IUserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepository(getDBConnection());
        }
        return userRepository;
    }
    
    public static IAuthService getAuthService() {
        if (authService == null) {
            authService = new AuthService(getUserRepository());
        }
        return authService;
    }
    
    public static IAuthController getAuthController() {
        if (authController == null) {
            authController = new AuthController(getAuthService(), getDBConnection());
        }
        return authController;
    }
}
