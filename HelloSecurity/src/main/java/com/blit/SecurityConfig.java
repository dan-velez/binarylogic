package com.blit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) 
    throws Exception {
        return http.httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(
                (c) -> {c.anyRequest().authenticated();}
            ).build();
    }

    @Bean
    public UserDetailsService userDetailService () {
        UserDetails admin = User.builder().username("admin")
            .password(bCryptPasswordEncoder().encode("password"))
            .roles("ADMIN").build();
        
        UserDetails user = User.builder().username("user")
            .password(bCryptPasswordEncoder().encode("password"))
            .roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder () {
        return new BCryptPasswordEncoder();
    }
}