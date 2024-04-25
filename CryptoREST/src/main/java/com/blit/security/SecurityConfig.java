package com.blit.security;

import org.springframework.security.config.Customizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.blit.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
    throws Exception {
		return http
				.csrf((c)->{c.disable();})
				.cors((c)->Customizer.withDefaults())
				.authorizeHttpRequests(//Authenticate all requests
                    (c)->{c.requestMatchers(HttpMethod.GET,
                            "api/v1/car/*").hasAnyRole(
                                "ADMIN","USER")
                    .requestMatchers(HttpMethod.POST, 
                            "api/v1/car/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, 
                            "api/v1/car/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, 
                            "api/v1/car/*").hasRole("ADMIN")
                    .anyRequest().authenticated();
                    })
				.httpBasic(Customizer.withDefaults())
				.build();
    }

    @Autowired
    private UserServiceImpl service; 

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
    throws Exception {
        auth.userDetailsService(service)
        .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}