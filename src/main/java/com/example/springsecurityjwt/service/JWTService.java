package com.example.springsecurityjwt.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken() {
        return "test-token";
    }

}
