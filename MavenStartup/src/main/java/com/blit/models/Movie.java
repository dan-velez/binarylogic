package com.blit.models;

public class Movie {

    public String title;
    public String director;
    public int yearReleased;
    
    public Movie (String title, String director, int yearReleased) {
        this.title = title;
        this.director = director;
        this.yearReleased = yearReleased;
    }

    public Movie () {
        super();
    }

    @Override
    public String toString () {
        return "Movie [title=" + title + ", director=" + 
        director + ", yearReleased=" + yearReleased + "]";
    }
}
