package com.example.codefellowship.controllers;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Post;
import com.example.codefellowship.repos.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
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
        return new RedirectView("/login");
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
    @GetMapping("/userprofile")
    public String printHi(@RequestParam Integer id, @AuthenticationPrincipal ApplicationUser user, Model model) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(user.getUsername());
        ApplicationUser userProfile = applicationUserRepository.findById(id).get();
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("userProfile", userProfile);
        return "userProfile.html";
    }
}