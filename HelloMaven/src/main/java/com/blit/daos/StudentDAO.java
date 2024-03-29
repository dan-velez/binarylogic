package com.blit.daos;

import java.util.List;

import com.blit.models.Student;

public interface StudentDAO {

    boolean addNewStudent (Student student);
    boolean deleteStudent (int id);
    boolean updateStudentRecord (Student student);
    List<Student> findAllStudents ();
    Student findStudentById (int id);
    
}
