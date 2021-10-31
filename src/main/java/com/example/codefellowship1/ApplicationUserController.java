package com.example.codefellowship1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import javax.xml.crypto.Data;
import java.util.Date;
@Controller
public class ApplicationUserController {
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImplemnet;
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }
    @GetMapping("/login")
    public String getSignInPage(){
        return "signin.html";
    }
    @GetMapping("/")
    public String getHomePage(){
        return "home.html";
    }
    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value="username")
                                           String username,
                               @RequestParam(value="password") String password,
                               @RequestParam(value = "firstname")String firstname,
                               @RequestParam(value = "lastname")String lastname,
                               @RequestParam(value = "dateofbirth") Integer dateofbirth,
                               @RequestParam(value = "bio")String bio){
        ApplicationUser newUser = new ApplicationUser(username,bCryptPasswordEncoder.encode(password),firstname,lastname,dateofbirth,bio);
        applicationUserRepository.save(newUser);
        return new RedirectView("/login");
    }
}