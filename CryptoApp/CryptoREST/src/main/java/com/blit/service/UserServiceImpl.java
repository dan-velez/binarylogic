package com.blit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.blit.entity.User;
import com.blit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) 
    throws UsernameNotFoundException {
        Optional<User> userOpt = repo.findByUsername(username);
        UserBuilder builder = null;

        if(userOpt.isPresent()) {
            User currUser = userOpt.get();
            builder = org.springframework.security.core.userdetails
                .User.withUsername(username);
            builder.password(currUser.getPassword());
            builder.roles(currUser.getRole());
            return builder.build();
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
