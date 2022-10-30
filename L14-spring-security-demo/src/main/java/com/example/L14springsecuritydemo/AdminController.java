package com.example.L14springsecuritydemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok("hello Admin "+appUser.getUsername()+" "+appUser.getPhone());
    }

//    @GetMapping("/changePassword")
    @PostMapping("/changePassword")
    ResponseEntity<String> changePassword(@RequestParam String newPassword){
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUserRepo.save(appUser);
        return ResponseEntity.ok("Password changed");
    }

    @PostMapping("/createUser")
    ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser){
        appUser = appUserService.createUser(appUser);
        return ResponseEntity.ok(appUser);
    }



}
