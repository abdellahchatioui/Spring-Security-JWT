package com.example.springsecurityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        return http
                // Disable CSRF security
                .csrf(AbstractHttpConfigurer::disable)
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

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("abde")
                .password("1234")
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("med")
                .password("1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
}
