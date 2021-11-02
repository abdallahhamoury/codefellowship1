package com.example.codefellowship.repos;

import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Post;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser,Integer> {
    public ApplicationUser findByUsername(String username);
}