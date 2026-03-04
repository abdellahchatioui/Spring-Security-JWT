package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UsersRepo usersrepo;

    public Users register(Users user){
        usersrepo.save(user);
        return user;
    }

}
