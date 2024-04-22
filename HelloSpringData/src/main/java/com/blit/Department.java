package com.blit;

/** Creating models using Spring JPA. */

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dept_id;

    @Column(unique = true, nullable = false)
    private String name;
    
    private String goal;
    
    @OneToMany
    List<Employee> employees;

    public Department(String name, String goal) {
        this.name = name;
        this.goal = goal;
    }

    public Department(int dept_id, String name, String goal) {
        this.dept_id = dept_id;
        this.name = name;
        this.goal = goal;
    }

    public int getDept_id() {
        return this.dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return this.goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
        
    @Override
    public String toString() {
        return "Department [dept_id=" + dept_id + ", name=" + name + 
        ", goal=" + goal + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dept_id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((goal == null) ? 0 : goal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        if (dept_id != other.dept_id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (goal == null) {
            if (other.goal != null)
                return false;
        } else if (!goal.equals(other.goal))
            return false;
        return true;
    }

}