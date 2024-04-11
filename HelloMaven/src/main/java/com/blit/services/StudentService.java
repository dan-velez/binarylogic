package com.blit.services;

/** Use the StudentDAO to provide DB service.*/

import java.util.List;
import java.util.ArrayList;

import com.blit.models.Student;

public class StudentService {

    public List<Student> findAllStudents () {
        List<Student> res = new ArrayList<Student>();
        res.add(new Student("Daniel", 1, 3.0, "M"));
        res.add(new Student("Jose", 2, 3.0, "M"));
        return res;
    }

    public Student getStudentById (int id) {
        return new Student("Daniel", 1, 3.0, "M");
    }

    public boolean addNewStudent (Student student) {
        return false;
    }

}
