/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.service;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
import ec.edu.espe.safestore.model.User;
import ec.edu.espe.safestore.repository.interfaces.IUserRepository;
import ec.edu.espe.safestore.service.interfaces.IAuthService;
import ec.edu.espe.safestore.utils.PasswordUtil;
import ec.edu.espe.safestore.utils.ValidationUtil;
import ec.edu.espe.safestore.utils.Constants;
import java.util.UUID;

public class AuthService implements IAuthService {
    
    private final IUserRepository userRepository;
    
    public AuthService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public boolean authenticate(String username, String password, String role) {
        if (!ValidationUtil.isValidUsername(username) || !ValidationUtil.isValidPassword(password)) {
            return false;
        }
        
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        
        if (!PasswordUtil.checkPassword(password, user.getPassword())) {
            return false;
        }
        
        if (!user.getRole().equals(role)) {
            return false;
        }
        
        if (!user.isActive()) {
            return false;
        }
        
        user.setLastLogin(java.time.LocalDateTime.now().toString());
        userRepository.update(user);
        
        return true;
    }
    
    @Override
    public boolean registerUser(String username, String password, String confirmPassword, 
                                String email, String role) {
        if (!ValidationUtil.isValidUsername(username)) {
            throw new IllegalArgumentException("Nombre de usuario invalido");
        }
        if (!ValidationUtil.isValidPassword(password)) {
            throw new IllegalArgumentException("La contrasena debe tener al menos " + 
                                               Constants.MIN_PASSWORD_LENGTH + " caracteres");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Las contrasenas no coinciden");
        }
        if (email != null && !ValidationUtil.isValidEmail(email)) {
            throw new IllegalArgumentException("Email invalido");
        }
        
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya esta en uso");
        }
        
        if (email != null && userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("El email ya esta registrado");
        }
        
        String encryptedPassword = PasswordUtil.encryptPassword(password);
        User user = new User(username, encryptedPassword, role);
        user.setEmail(email);
        user.setActive(true);
        
        return userRepository.save(user);
    }
    
    @Override
    public boolean generateResetToken(String usernameOrEmail) {
        User user = userRepository.findByUsername(usernameOrEmail);
        if (user == null) {
            user = userRepository.findByEmail(usernameOrEmail);
        }
        
        if (user == null) {
            return false;
        }
        
        String resetToken = UUID.randomUUID().toString();
        String expiry = java.time.LocalDateTime.now()
            .plusHours(Constants.TOKEN_EXPIRY_HOURS).toString();
        
        user.setResetToken(resetToken);
        user.setResetTokenExpiry(expiry);
        
        return userRepository.update(user);
    }
    
    @Override
    public boolean isValidResetToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        
        User user = userRepository.findByResetToken(token);
        if (user == null) {
            return false;
        }
        
        if (user.getResetTokenExpiry() != null) {
            try {
                java.time.LocalDateTime expiry = java.time.LocalDateTime.parse(user.getResetTokenExpiry());
                if (java.time.LocalDateTime.now().isAfter(expiry)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public boolean resetPassword(String token, String newPassword, String confirmPassword) {
        if (!isValidResetToken(token)) {
            throw new IllegalArgumentException("Codigo invalido o expirado");
        }
        
        if (!ValidationUtil.isValidPassword(newPassword)) {
            throw new IllegalArgumentException("La contrasena debe tener al menos " + 
                                               Constants.MIN_PASSWORD_LENGTH + " caracteres");
        }
        
        if (!newPassword.equals(confirmPassword)) {
            throw new IllegalArgumentException("Las contrasenas no coinciden");
        }
        
        User user = userRepository.findByResetToken(token);
        if (user == null) {
            return false;
        }
        
        user.setPassword(PasswordUtil.encryptPassword(newPassword));
        user.setResetToken(null);
        user.setResetTokenExpiry(null);
        
        return userRepository.update(user);
    }
    
    @Override
    public boolean changePassword(String username, String oldPassword, 
                                  String newPassword, String confirmPassword) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        
        if (!PasswordUtil.checkPassword(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Contrasena actual incorrecta");
        }
        
        if (!ValidationUtil.isValidPassword(newPassword)) {
            throw new IllegalArgumentException("La nueva contrasena debe tener al menos " + 
                                               Constants.MIN_PASSWORD_LENGTH + " caracteres");
        }
        
        if (!newPassword.equals(confirmPassword)) {
            throw new IllegalArgumentException("Las contrasenas no coinciden");
        }
        
        user.setPassword(PasswordUtil.encryptPassword(newPassword));
        return userRepository.update(user);
    }
    
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public boolean isUserActive(String username) {
        User user = userRepository.findByUsername(username);
        return user != null && user.isActive();
    }
}
