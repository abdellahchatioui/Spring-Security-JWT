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

        // Disable CSRF security
        http.csrf(customize -> customize.disable());
        // Authorize Request
        http.authorizeHttpRequests(
                request ->
                        request.anyRequest().authenticated());

        // Show Form Login
        http.formLogin(Customizer.withDefaults());
        // Allow postman request
        http.httpBasic(Customizer.withDefaults());
        // Session StateLess
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        return http.build();
    }
}
