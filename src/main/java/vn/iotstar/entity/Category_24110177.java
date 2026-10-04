package vn.iotstar.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Category")
public class Category_24110177 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Categoryld")
    private int categoryid;
    
    @Column(name = "Categoryname", length = 100)
    private String categoryname;
    
    @Column(name = "Categorycode", length = 100)
    private String categorycode;
    
    @Column(name = "Images", length = 500)
    private String images;
    
    @Column(name = "Status")
    private boolean status;

    // Getters & Setters
    public int getCategoryid() { return categoryid; }
    public void setCategoryid(int categoryid) { this.categoryid = categoryid; }
    public String getCategoryname() { return categoryname; }
    public void setCategoryname(String categoryname) { this.categoryname = categoryname; }
    public String getCategorycode() { return categorycode; }
    public void setCategorycode(String categorycode) { this.categorycode = categorycode; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}