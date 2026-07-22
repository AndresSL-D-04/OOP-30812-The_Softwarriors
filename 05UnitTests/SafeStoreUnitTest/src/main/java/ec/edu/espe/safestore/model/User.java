package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

public class User {
    private String userName;
    private String password;
    private String role;
    private String email;
    private String resetToken;
    private String resetTokenExpiry;
    private boolean active;
    private String createdAt;
    private String lastLogin;
    
    public User() {
        this.active = true;
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public User(String username, String password, String role) {
        this.userName = username;
        this.password = password;
        this.role = role;
        this.active = true;
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public String getUsername() { return userName; }
    public void setUsername(String username) { this.userName = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getResetToken() { return resetToken; }
    public void setResetToken(String resetToken) { this.resetToken = resetToken; }
    
    public String getResetTokenExpiry() { return resetTokenExpiry; }
    public void setResetTokenExpiry(String resetTokenExpiry) { this.resetTokenExpiry = resetTokenExpiry; }
    
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    
    public String getLastLogin() { return lastLogin; }
    public void setLastLogin(String lastLogin) { this.lastLogin = lastLogin; }
    
    @Override
    public String toString() {
        return "User{username=" + userName + ", role=" + role + ", email=" + email + ", active=" + active + "}";
    }
}