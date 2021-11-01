package com.example.codefellowship1;

import org.springframework.data.repository.CrudRepository;
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser,Integer>{
    public ApplicationUser findByUsername(String username);
}
