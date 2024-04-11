package com.blit;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blit.controllers.MovieController;
import com.blit.daos.MovieDAO;
import com.blit.daos.MovieDAOImpl;
import com.blit.services.MovieService;

@Configuration
public class AppConfig {

    @Bean(name="movieDao")
    public MovieDAO getMovieDao () {
        return new MovieDAOImpl();
    }

    @Bean
    public MovieService getMovieService () {
        return new MovieService(getMovieDao());
    }

    @Bean(name="movieController")
    public MovieController getMovieController () {
        return new MovieController(getMovieService(), getConsoleScanner());
    }

    @Bean
    public Scanner getConsoleScanner () {
        return new Scanner(System.in);
    }
}
