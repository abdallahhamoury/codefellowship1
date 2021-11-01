package com.example.codefellowship1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser= applicationUserRepository.findByUsername(username);
        if(applicationUser==null){
            throw new UsernameNotFoundException("the user name "+username+"not found");
        }
        return applicationUser;
    }
    //    public ApplicationUser getUserById(int id) {
//       ApplicationUser applicationUserid=applicationUserRepository.findById(id) ;
//      return applicationUserid;
//    }
}
