package com.blit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blit.Employee;
import com.blit.services.EmployeeService;

@RestController /* Working with JSON. */
@RequestMapping("/employees") /* Base Path for Employee resources. */
public class EmployeeController {
    
    private EmployeeService service;
 
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees () {
        return service.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> addNewEmployee (@RequestBody Employee emp) {
        emp = service.addNewEmployee(emp);
        return ResponseEntity.status(201).body(emp);
    }

}