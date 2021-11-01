package com.example.codefellowship1;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    String username;
    String password;
    String firstname;
    String lastname;
    String dateofbirth;
    String bio;
    @OneToMany(mappedBy = "applicationUser")
    List<Post> allposts;
    public ApplicationUser(String username, String password, String firstname, String lastname, String dateofbirth,String bio) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.bio = bio;
    }
    public ApplicationUser(){

    }
    public List<Post> getAllposts() {
        return allposts;
    }
    public void setAllposts(List<Post> allposts) {
        this.allposts = allposts;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getDateofbirth() {
        return dateofbirth;
    }
    public String getBio() {
        return bio;
    }
    public Integer getId() {
        return id;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public void setDateOfBirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}