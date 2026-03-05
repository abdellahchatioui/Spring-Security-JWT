package com.example.springsecurityjwt.dto;


public class loginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public loginRequest() {
    }

    public loginRequest(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
