package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.repo.UsersRepo;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HomeController {

    @GetMapping("/home")
    public String home (){
        return "hello ";
    }

    @GetMapping("/session")
    public String session (HttpSession session){
        return "Session Id : " + session.getId();
    }

    @GetMapping("/csrf")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
