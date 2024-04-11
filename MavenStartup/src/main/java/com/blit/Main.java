package com.blit;

/** Introduction to Spring Framework. */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blit.controllers.MovieController;

public class Main {

    public static void main (String[] args) {
        System.out.println("Hello Spring");
        ApplicationContext app = 
            //new ClassPathXmlApplicationContext("applicationContext.xml");
            new AnnotationConfigApplicationContext(AppConfig.class);
        MovieController mc = (MovieController)app.getBean("movie");
        mc.showMovies();
        System.out.println("Let's create a new movie:");
        mc.addNewMovie();
        mc.showMovies();
    }

}