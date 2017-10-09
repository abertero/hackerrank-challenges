package com.amazon;

import java.util.ArrayList;

public class Movie {
    private int movieId;
    private float rating;
    private ArrayList<Movie> similarMovies = new ArrayList<>();

    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public float getRating() {
        return rating;
    }

    public ArrayList<Movie> getSimilarMovies() {
        return similarMovies;
    }
}
