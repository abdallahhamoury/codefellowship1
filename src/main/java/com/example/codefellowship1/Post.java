package com.example.codefellowship1;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String body;
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    private LocalDate createdAt;
    @ManyToOne
    private ApplicationUser applicationUser;
    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }
    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }
    public Post(){
        //default
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Post(String body,ApplicationUser applicationUser) {
        this.body = body;
        this.applicationUser = applicationUser;
        this.createdAt = LocalDate.now();
    }
}
