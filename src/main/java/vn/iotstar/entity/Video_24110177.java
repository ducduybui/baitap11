package vn.iotstar.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Videos")
public class Video_24110177 implements Serializable {
    @Id
    @Column(name = "Videold", length = 50)
    private String videoid;
    
    @Column(name = "Title", length = 200)
    private String title;
    
    @Column(name = "Poster", length = 50)
    private String poster;
    
    @Column(name = "Views")
    private int views;
    
    @Column(name = "Description", length = 500)
    private String description;
    
    @Column(name = "Active")
    private boolean active;
    
    @Column(name = "Categoryld")
    private int categoryid;

    // Getters and Setters
    public String getVideoid() { return videoid; }
    public void setVideoid(String videoid) { this.videoid = videoid; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }
    public int getViews() { return views; }
    public void setViews(int views) { this.views = views; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public int getCategoryid() { return categoryid; }
    public void setCategoryid(int categoryid) { this.categoryid = categoryid; }
}