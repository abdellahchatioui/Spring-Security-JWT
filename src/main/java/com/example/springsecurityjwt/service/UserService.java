package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UsersRepo usersrepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        usersrepo.save(user);
        return user;
    }

}
