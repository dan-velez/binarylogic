package com.blit.controllers;

/** A JSON API using the `StudentService` class. */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.blit.services.StudentService;
import com.blit.models.Student;

public class StudentServlet extends HttpServlet {
    
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        // Determine request type.
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        String uri = req.getRequestURI();
        String[] sections = uri.split("/");

        int sectionsLength = sections.length;

        if (sectionsLength == 3) {
            // Get all students and send as JSON.
            List<Student> list = this.studentService.findAllStudents();
            list.add(new Student("Daniel", 3.0, "M"));
            json = mapper.writeValueAsString(list);
            
        } else if (sectionsLength == 4) {
            try {
                // Retrieve student and send as JSON.
                int id = Integer.parseInt(sections[3]);
                Student student = studentService.getStudentById(id);
                json = mapper.writeValueAsString(student);          
            } catch (NumberFormatException e) {
                e.printStackTrace();
                resp.setStatus(404);
            }
        }

        PrintWriter writer = resp.getWriter();
        writer.write(json);
        resp.setStatus(200);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
        // Get JSON from request.
        BufferedReader reader = req.getReader();

        // Read JSON to Java object.
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(reader, Student.class);

        if(studentService.addNewStudent(student)) {
            resp.setStatus(201); // 201: Created
        } else {
            resp.setStatus(400);
        }
    }

}