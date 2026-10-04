package vn.iotstar.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Users")
public class User_24110177 implements Serializable {
    @Id
    @Column(name = "Username", length = 50)
    private String username;
    
    @Column(name = "Password", length = 50, nullable = false)
    private String password;
    
    @Column(name = "Phone", length = 15)
    private String phone;
    
    @Column(name = "Fullname", length = 50)
    private String fullname;
    
    @Column(name = "Email", length = 150)
    private String email;
    
    @Column(name = "Admin")
    private boolean admin;
    
    @Column(name = "Active")
    private boolean active;
    
    @Column(name = "Images", length = 500)
    private String images;

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}