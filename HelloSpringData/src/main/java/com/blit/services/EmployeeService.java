package com.blit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blit.Employee;
import com.blit.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    
    EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        super();
        this.repo = repo;
    }

    public List<Employee> getAllEmployees () {
        return repo.findAll();
    }

    public Employee addNewEmployee (Employee emp) {
        /* Insert new entity or update existing. */
        return repo.save(emp);
    }

}
