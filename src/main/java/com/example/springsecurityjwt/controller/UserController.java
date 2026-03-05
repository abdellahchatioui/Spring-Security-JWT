package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.dto.loginRequest;
import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class UserController {

    @Autowired
    UserService userservice;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userservice.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody loginRequest user){
        return userservice.verify(user);
    }

}
