package com.blit;

import com.blit.daos.StudentDAO;
import com.blit.daos.StudentDAOMySQLImpl;
import com.blit.models.Student;

import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {
    
    public static void displayStudents () {
        System.out.println("How would you like students sorted?");
        System.err.println("1. By Name.");
        System.out.println("2. By GPA.");
        System.out.println("0. No particular order.");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
    }

    public List<Student> getAllStudents (String sortType) {
        StudentDAO studentDAO = new StudentDAOMySQLImpl();
        List<Student> students = studentDAO.findAllStudents();

        if (sortType.equals(1)) {
            students.sort(
                (o1, o2) -> { 
                    return o1.getName().compareToIgnoreCase(o2.getName()); 
                });
        } else if (sortType.equals(2)) {
            students.sort(
                (o1, o2) -> {
                    double d = o1.getGpa();
                    if (d > 0) { return 1; }
                    if (d < 0) { return -1; }
                    return 0;
                });
        }

        return students;
    }

    public static void runStudentProgram () {
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

    public static void main ( String[] args ) {
        System.out.println("Hello Maven.");
        System.out.println("JSON Library install.");
        System.out.println("------------------------");
        new HelloThreads();
    }

}
