package com.blit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.Department;

public interface DepartmentRepository 
extends JpaRepository <Department, Integer> {
    
}
