package com.example.L13springsecuritydemo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
        return ResponseEntity.ok("hello user");
    }
}
// D142926DA0CBEF1F5EAB413EC7F3D66D
// D142926DA0CBEF1F5EAB413EC7F3D66D
// D142926DA0CBEF1F5EAB413EC7F3D66D
// D32FC6650B9020BCD1AF8369FBCC6C80
// D32FC6650B9020BCD1AF8369FBCC6C80
// D32FC6650B9020BCD1AF8369FBCC6C80