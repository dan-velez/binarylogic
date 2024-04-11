package com.blit.controllers;

import com.blit.services.MovieService;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.blit.models.Movie;

@Controller("movieController")
public class MovieController {

    private MovieService movieService;
    private Scanner scan;

    @Autowired
    public MovieController (MovieService movieService, Scanner scan) {
        this.scan = scan;
        this.movieService = movieService;
    }


    public MovieController (MovieService movieService) {
        this.movieService = movieService;
    }

    public void setMovieService (MovieService movieService) {
        this.movieService = movieService;
    }

    public void showMovies () {
        List<Movie> list = movieService.getAllMovies();
        System.out.println("Here are your movies:");
        for (Movie m : list) {
            System.out.println(m);
        }
        System.out.println("=====================");
    }

    public void addNewMovie () {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the new movie title?");
        String title = scan.nextLine();

        System.out.println("Who is the director?");
        String director = scan.nextLine();

        System.out.println("What year was it made?");
        String yearString = scan.nextLine();
        int year = Integer.parseInt(yearString);

        movieService.addMovie(title, director, year);
        System.out.println("Your movie is added.");
    }

}
