package com.blit;

import com.blit.daos.StudentDAOMySQLImpl;
import com.blit.models.Student;
import com.blit.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {

    public static void main ( String[] args ) {
        System.out.println("Hello Maven.");
        System.out.println("JSON Library install.");
        System.out.println("------------------------");

        StudentDAOMySQLImpl studentDao = new StudentDAOMySQLImpl();
        List<Student> students = studentDao.findAllStudents();
        for(Student s : students) {
            System.out.println(s);
        }

        studentDao.addNewStudent(new Student("Kal", 3.86, "M"));

        JSONObject obj = new JSONObject("{\"A\":1}");
        obj.put("B", 2);
        obj.put("C", 3);
        System.out.println(obj.toString(4));

        JSONArray jarr = new JSONArray();
        jarr.put(obj);
        jarr.put(obj);
        jarr.put(obj);

        System.out.println(jarr.toString(4));
    }

}
