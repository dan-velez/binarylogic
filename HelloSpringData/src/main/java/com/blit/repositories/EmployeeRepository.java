package com.blit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blit.Employee;

/* Type of entity and type of the @Id of the entity. */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
