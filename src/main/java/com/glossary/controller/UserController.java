package com.glossary.controller;

import java.io.Console;

import com.glossary.domain.User;
import com.glossary.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId){
        System.out.println("sd");
        User user=userService.findByUserId(userId);
        UserResponse response=UserResponse.builder().user(user).build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/user/{uid}")
    public ResponseEntity<HttpStatus> setUser(@PathVariable String uid){
        userService.insert(uid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
