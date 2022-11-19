package com.example;

import com.example.dto.UserDto;
import com.example.dto.UserProfile;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user-service")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    ResponseEntity<Long> createUser(@RequestBody UserDto userDto) throws ExecutionException, InterruptedException, JsonProcessingException {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @GetMapping("/user")
    ResponseEntity<UserProfile> getUserProfile(@RequestHeader Long id) throws UserNotExistException {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }



}
