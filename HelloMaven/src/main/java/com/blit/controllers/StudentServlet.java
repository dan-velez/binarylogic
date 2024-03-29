package com.blit.controllers;

import jakarta.servlet.http.HttpServlet;

import com.blit.services.StudentService;

public class StudentServlet extends HttpServlet {
    
    private StudentService studentService = new StudentService();

}