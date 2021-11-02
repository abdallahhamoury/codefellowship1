package com.example.codefellowship.repos;


import com.example.codefellowship.models.ApplicationUser;
import com.example.codefellowship.models.Post;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllByUser(ApplicationUser applicationUser);
}