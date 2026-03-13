package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.dto.loginRequest;
import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.repo.UsersRepo;
import com.example.springsecurityjwt.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepo usersrepo;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;



    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        usersrepo.save(user);
        return user;
    }

    public String verify(loginRequest user) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );

        // System.out.println(user.getUsername());
        if(authentication.isAuthenticated()){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            // Argument 'userDetails' might be null
            assert userDetails != null;
            return jwtService.generateToken(userDetails);
        }
        return "Faild";

    }
}
