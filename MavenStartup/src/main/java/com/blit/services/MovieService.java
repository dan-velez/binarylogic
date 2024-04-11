package com.blit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blit.daos.MovieDAO;
import com.blit.models.Movie;

@Service
public class MovieService {

    private MovieDAO movieDao;

    public MovieService (MovieDAO movieDao) {
        this.movieDao = movieDao;
    }

    @Autowired /* Setter injection. */
    public void setMovieDao (MovieDAO movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getAllMovies () {
        return this.movieDao.getAllMovies();
    }

    public void addMovie (String title, String director, int year) {
        movieDao.addMovie(new Movie(title, director, year));
    }
}