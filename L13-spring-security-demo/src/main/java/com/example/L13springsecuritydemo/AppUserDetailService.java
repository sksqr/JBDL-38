package com.example.L13springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = appUserRepo.findByUsername(username);
        if(userDetails == null){
            throw  new UsernameNotFoundException("No User");
        }
        return userDetails;
    }
}
