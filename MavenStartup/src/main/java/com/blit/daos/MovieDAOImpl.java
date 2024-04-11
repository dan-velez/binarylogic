package com.blit.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.blit.models.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {
    
    List<Movie> movieList = new ArrayList<>();

    public MovieDAOImpl () {
        movieList.add(new Movie(
            "The Lord of The Rings: The Fellowship of the Ring",
            "Peter Jackson",
            2000
        ));

        movieList.add(new Movie(
            "The Matrix",
            "Wolkaski Sisters",
            2000
        ));

        movieList.add(new Movie(
            "Cowboys and Angels",
            "David Gleeson",
            2003
        ));
    }

    @Override
    public List<Movie> getAllMovies () {
        return this.movieList;
    }

    @Override
    public void addMovie (Movie movie) {
        this.movieList.add(movie);
    }

}
