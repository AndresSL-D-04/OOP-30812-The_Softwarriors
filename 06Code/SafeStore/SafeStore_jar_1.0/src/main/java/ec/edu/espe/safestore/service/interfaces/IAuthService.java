/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.service.interfaces;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
import ec.edu.espe.safestore.model.User;

public interface IAuthService {
    boolean authenticate(String username, String password, String role);
    boolean registerUser(String username, String password, String confirmPassword, String email, String role);
    boolean generateResetToken(String usernameOrEmail);
    boolean isValidResetToken(String token);
    boolean resetPassword(String token, String newPassword, String confirmPassword);
    boolean changePassword(String username, String oldPassword, String newPassword, String confirmPassword);
    User findByUsername(String username);
    User findByEmail(String email);
    boolean isUserActive(String username);
}
