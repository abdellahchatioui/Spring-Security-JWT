package com.example.springsecurityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){


        return http
                // Disable CSRF security
                .csrf(customize -> customize.disable())
                // Authorize Request
                .authorizeHttpRequests(
                        request ->
                                request.anyRequest().authenticated())
                // Show Form Login
                .formLogin(Customizer.withDefaults())
                // Allow postman request
                .httpBasic(Customizer.withDefaults())
                // Session StateLess
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }
}
