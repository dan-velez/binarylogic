package com.blit.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    /** 
     * HttpServlet requires that at least one method is overridden so it can
     * handle an Http Request. This can be the generic `serivce()` method or
     * one of the verb specific methods `doVerb()`, e.g. `doGet()`.
     */

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        System.out.println(req.getHeaderNames());    
        System.out.println(req.getRequestURI()); /* Location req was sent to. */

        PrintWriter printWriter = resp.getWriter();

        printWriter.print("<h1>Hello From Servlet</h1>"+
            "<br>"+
            "<p>You sent a GET request.</p>");

        resp.setStatus(200);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        System.out.println(req.getHeaderNames());    
        System.out.println(req.getRequestURI()); /* Location req was sent to. */

        PrintWriter printWriter = resp.getWriter();

        printWriter.print("<h1>Hello From Servlet</h1>"+
            "<br>"+
            "<p>You sent a POST request.</p>");

        resp.setStatus(201);
    }

}
