package com.blit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello") /* This is the subdomain. */
public class HelloController {

    /* Sets the verb and the subpath. */
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public ResponseEntity<String> sayHello () {
        /* Can set body, status code, headers with ResponseEntity. */
        return ResponseEntity.status(200)
            .contentType(MediaType.TEXT_HTML)
            .body("<h1> Hello, Spring Boot.</h1>");
    }

    /* Not RESTful. It returns a view from the ViewResolver. */
    @GetMapping /* Same as requestmapping above */
    public String sayHelloFromVR () {
        return "hello.html";
    }

    @GetMapping("/{count}")
    @ResponseBody /* Returns as a JSON. */
    public List<Integer> countIntegers (@PathVariable int count) {
        List<Integer> ints = new ArrayList<>();
        
        for (; count > 0; --count) {
            ints.add(count+1);
        }

        return ints;
    }

    @PostMapping
    public ResponseEntity newPerson (@RequestBody Person person) {
        System.out.println("Person with name: "+person.name+
            " and age "+person.age+" created.");
        return ResponseEntity.status(201).build();
    }
}


class Person {
    public String name;
    public int age;
}
