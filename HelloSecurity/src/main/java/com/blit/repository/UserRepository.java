package com.blit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    
}
