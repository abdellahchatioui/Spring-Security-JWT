package com.example.springsecurityjwt.repo;

import com.example.springsecurityjwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Integer, Users> {

}
