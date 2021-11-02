package com.example.codefellowship.models;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String body;
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne
    private ApplicationUser user;
    public Post(){}
    public Post(String body , ApplicationUser user) {
        this.body = body;
        this.user = user;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public int getId() {
        return id;
    }
    public ApplicationUser getUser() {
        return user;
    }
    public void setUser(ApplicationUser user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", created At=" + createdAt +
                ", user=" + user +
                '}';
    }
}