package com.example.codefellowship.controllers;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Post;
import com.example.codefellowship.repos.ApplicationUserRepository;
import com.example.codefellowship.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    PostRepository postRepository;
    @GetMapping("/signup")
    public String getSignUpPage(@AuthenticationPrincipal ApplicationUser user , Model model) {
        if (user != null)model.addAttribute("username", applicationUserRepository.findByUsername(user.getUsername()).getUsername());
        return "signup.html";
    }
    @GetMapping("/login")
    public String getSignInPage(@AuthenticationPrincipal ApplicationUser user , Model model) {
        if (user != null)model.addAttribute("username", applicationUserRepository.findByUsername(user.getUsername()).getUsername());
        return "signin.html";
    }
    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "dateOfBirth") String dateOfBirth, @RequestParam(value = "bio") String bio) {
        ApplicationUser newUser = new ApplicationUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser,null,new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/profile");
    }
    @GetMapping("/feed")
    public String feel(@AuthenticationPrincipal ApplicationUser user , Model model) {
        if (user != null){
            Set<ApplicationUser> myFollowing = applicationUserRepository.findByUsername(user.getUsername()).getFollowing();
            List<Post> postList = new ArrayList();
            for (ApplicationUser currentFollower : myFollowing) {
                postList.addAll(currentFollower.getPostList());
            }
            model.addAttribute("postList", postList);
        }
        return "feed.html";
    }
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id , Model model, Principal principal){
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(principal.getName());
        if(id == loggedInUser.getId()) {
            model.addAttribute("user", applicationUserRepository.findById(id).get());
            model.addAttribute("userId", loggedInUser.getId());
            model.addAttribute("username", loggedInUser.getUsername());
            model.addAttribute("firstName", loggedInUser.getFirstName());
            model.addAttribute("lastName", loggedInUser.getLastName());
            model.addAttribute("dateOfBirth", loggedInUser.getDateOfBirth());
            model.addAttribute("bio", loggedInUser.getBio());
            List<Post> postList = postRepository.findAllByUser(loggedInUser);
            model.addAttribute("postList", postList);
            return "profile";
        }else {
            model.addAttribute("loggedInUser", loggedInUser);
            model.addAttribute("userProfile", applicationUserRepository.findById(id).get());
            return "userProfile";
        }
    }
    @GetMapping("/allUser")
    public String allUser( Model model){
        List<ApplicationUser> user = (List<ApplicationUser>) applicationUserRepository.findAll();
        model.addAttribute("users", user);
        return "allUser";

    }
    @PostMapping("/follow/{id}")
    public RedirectView follow(@PathVariable int id, Principal principal){
        ApplicationUser followingUser = applicationUserRepository.findById(id).get();
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(principal.getName());
        loggedInUser.setFollowing(followingUser);
        applicationUserRepository.save(loggedInUser);
        return new RedirectView("/user/"+id);
    }
}