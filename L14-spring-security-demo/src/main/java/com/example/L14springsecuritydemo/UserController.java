package com.example.L14springsecuritydemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
//        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return ResponseEntity.ok("hello user "+appUser.getUsername()+" "+appUser.getPhone());
        return ResponseEntity.ok("hello user ");
    }


    @PostMapping("/hello")
    ResponseEntity<String> postHello(){
//        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return ResponseEntity.ok("hello user "+appUser.getUsername()+" "+appUser.getPhone());
        return ResponseEntity.ok("hello user ");
    }
}
// D142926DA0CBEF1F5EAB413EC7F3D66D
// D142926DA0CBEF1F5EAB413EC7F3D66D
// D142926DA0CBEF1F5EAB413EC7F3D66D
// D32FC6650B9020BCD1AF8369FBCC6C80
// D32FC6650B9020BCD1AF8369FBCC6C80
// D32FC6650B9020BCD1AF8369FBCC6C80