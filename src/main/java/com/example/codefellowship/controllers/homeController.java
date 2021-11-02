package com.example.codefellowship.controllers;


import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Post;
import com.example.codefellowship.repos.ApplicationUserRepository;
import com.example.codefellowship.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;
@Controller
public class homeController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;
    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal ApplicationUser user, Model model) {
        List<Post> postList = (List<Post>) postRepository.findAll();
        if (user != null) {
            ApplicationUser currentUser = applicationUserRepository.findByUsername(user.getUsername());
            model.addAttribute("username", currentUser.getUsername());
            List<Post> myFollowingPost = new ArrayList();
            for (Post post : postList) {
                if (!currentUser.getFollowing().contains(post.getUser()) && post.getUser() != currentUser)  myFollowingPost.add(post);
            }
            model.addAttribute("postList", myFollowingPost);
        } else {
            model.addAttribute("postList", postList);
        }
        return "home.html";
    }
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal ApplicationUser user, Model model) {
        if (user != null) {
            ApplicationUser currentUser = applicationUserRepository.findByUsername(user.getUsername());
            model.addAttribute("userId", currentUser.getId());
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("firstName", currentUser.getFirstName());
            model.addAttribute("lastName", currentUser.getLastName());
            model.addAttribute("dateOfBirth", currentUser.getDateOfBirth());
            model.addAttribute("bio", currentUser.getBio());
            List<Post> postList = postRepository.findAllByUser(currentUser);
            model.addAttribute("postList", postList);
        }
        return "profile.html";
    }
    @PostMapping("/follow")
    public RedirectView printHi(@RequestParam Integer id, @AuthenticationPrincipal ApplicationUser user, Model model) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(user.getUsername());
        ApplicationUser newFollowing = applicationUserRepository.findById(id).get();
        currentUser.setFollowing(newFollowing);
        applicationUserRepository.save(currentUser);
        return new RedirectView("/");
    }
}