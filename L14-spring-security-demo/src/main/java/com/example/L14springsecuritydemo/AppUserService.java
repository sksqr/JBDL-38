package com.example.L14springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  AppUserRepo appUserRepo;


    public AppUser createUser(AppUser appUser){
       // appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);
        return appUser;
    }
}

