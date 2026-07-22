package ec.edu.espe.safestore.controller;

import ec.edu.espe.safestore.controller.interfaces.IAuthController;
import ec.edu.espe.safestore.model.User;
import ec.edu.espe.safestore.service.interfaces.IAuthService;
import ec.edu.espe.safestore.utils.DataInitializer;
import ec.edu.espe.safestore.utils.MongoDBConnection;
import java.util.List;

/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */

public class AuthController implements IAuthController {
    
    private final IAuthService authService;
    private final DataInitializer dataInitializer;
    
    public AuthController(IAuthService authService, MongoDBConnection dbConnection) {
        this.authService = authService;
        this.dataInitializer = new DataInitializer(dbConnection);
        this.dataInitializer.initializeDefaultUsers();
    }
    
    @Override
    public boolean authenticate(String username, String password, String role) {
        return authService.authenticate(username, password, role);
    }
    
    @Override
    public boolean addUser(String username, String password, String role) {
        try {
            return authService.registerUser(username, password, password, null, role);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    @Override
    public boolean registerUser(String username, String password, String confirmPassword, 
                                String email, String role) {
        return authService.registerUser(username, password, confirmPassword, email, role);
    }
    
    @Override
    public boolean generateResetToken(String usernameOrEmail) {
        return authService.generateResetToken(usernameOrEmail);
    }
    
    @Override
    public boolean isValidResetToken(String token) {
        return authService.isValidResetToken(token);
    }
    
    @Override
    public boolean resetPassword(String token, String newPassword, String confirmPassword) {
        return authService.resetPassword(token, newPassword, confirmPassword);
    }
    
    @Override
    public boolean changePassword(String username, String oldPassword, 
                                  String newPassword, String confirmPassword) {
        return authService.changePassword(username, oldPassword, newPassword, confirmPassword);
    }
    
    @Override
    public User findByUsername(String username) {
        return authService.findByUsername(username);
    }
    
    @Override
    public User findByEmail(String email) {
        return authService.findByEmail(email);
    }
    
    @Override
    public List<User> getAllUsers() {
        return null;
    }
}