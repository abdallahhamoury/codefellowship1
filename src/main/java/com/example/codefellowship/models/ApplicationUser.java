package com.example.codefellowship.models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.*;
@Entity
@Table (name = "userdata")
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String bio;
    @OneToMany(mappedBy = "user")
    private List<Post> postList;
    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name = "following_follower" , joinColumns = {@JoinColumn(name = "following_id")} , inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    private Set<ApplicationUser> following = new HashSet<>();
    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name = "following_follower" , joinColumns = {@JoinColumn(name = "follower_id")} , inverseJoinColumns = {@JoinColumn(name = "following_id")})
    private List<ApplicationUser> myFollowers = new ArrayList<>();
    public ApplicationUser(){}
    public ApplicationUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
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
    public int getId() {
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public List<Post> getPostList() {
        return postList;
    }
    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
    public Set<ApplicationUser> getFollowing() {
        return following;
    }
    public void setFollowing(ApplicationUser newFollowing) {
        this.following.add(newFollowing);
    }
    public List<ApplicationUser> getMyFollowers() {
        return myFollowers;
    }
    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}