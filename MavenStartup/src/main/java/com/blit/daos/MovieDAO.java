package com.blit.daos;

import java.util.List;

import com.blit.models.Movie;

public interface MovieDAO {
    
    List<Movie> getAllMovies ();
    void addMovie (Movie movie);
}
