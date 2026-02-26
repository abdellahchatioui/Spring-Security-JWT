package com.example.springsecurityjwt.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
