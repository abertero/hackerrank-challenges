package com.amazon;

import java.util.HashSet;
import java.util.Set;

public class SimilarMovies {

    public static void main(String[] args) {
        Movie m1 = new Movie(1, 1.2f);
        m1.getSimilarMovies().add(new Movie(2, 3.6f));
        m1.getSimilarMovies().add(new Movie(3, 2.4f));
        SimilarMovies sm = new SimilarMovies();
        print(sm.getMovieRecommendations(m1, 1));

        Movie mm1 = new Movie(1, 6.2f);
        Movie mm2 = new Movie(2, 3.6f);
        Movie mm3 = new Movie(3, 2.4f);
        Movie mm4 = new Movie(4, 9.8f);
        Movie mm5 = new Movie(5, 5.1f);
        Movie mm6 = new Movie(6, 8.4f);
        Movie mm7 = new Movie(7, 8.4f);
        Movie mm8 = new Movie(8, 8.0f);
        mm1.getSimilarMovies().add(mm2);
        mm1.getSimilarMovies().add(mm3);
        mm1.getSimilarMovies().add(mm4);
        mm2.getSimilarMovies().add(mm1);
        mm2.getSimilarMovies().add(mm5);
        mm3.getSimilarMovies().add(mm1);
        mm3.getSimilarMovies().add(mm5);
        mm4.getSimilarMovies().add(mm1);
        mm4.getSimilarMovies().add(mm6);
        mm4.getSimilarMovies().add(mm7);
        mm5.getSimilarMovies().add(mm2);
        mm5.getSimilarMovies().add(mm3);
        mm6.getSimilarMovies().add(mm4);
        mm6.getSimilarMovies().add(mm7);
        mm7.getSimilarMovies().add(mm4);
        mm7.getSimilarMovies().add(mm6);
        mm7.getSimilarMovies().add(mm8);
        mm8.getSimilarMovies().add(mm7);

        print(sm.getMovieRecommendations(mm1, 4));
    }

    private static void print(Set<Movie> movieRecommendations) {
        for (Movie movieRecommendation : movieRecommendations) {
            System.out.print(movieRecommendation.getMovieId() + " ");
        }
        System.out.println();
    }

    public Set<Movie> getMovieRecommendations(Movie movie, int N) {
        Set<Movie> recommendations = new HashSet<>();
        for (Movie similar : movie.getSimilarMovies()) {
            addAll(recommendations, similar, movie);
        }
        if (recommendations.size() <= N) {
            return recommendations;
        } else {
            Set<Movie> bestMovies = new HashSet<>();
            for (Movie recommendation : recommendations) {
                if (bestMovies.size() < N) {
                    bestMovies.add(recommendation);
                } else {
                    Movie worstMovie = null;
                    for (Movie bestMovie : bestMovies) {
                        if (worstMovie == null) {
                            worstMovie = bestMovie;
                        } else if (worstMovie.getRating() > bestMovie.getRating()) {
                            worstMovie = bestMovie;
                        }
                    }
                    if (worstMovie != null && worstMovie.getRating() < recommendation.getRating()) {
                        bestMovies.remove(worstMovie);
                        bestMovies.add(recommendation);
                    }
                }
            }
            return bestMovies;
        }
    }

    private void addAll(Set<Movie> allSet, Movie movie, Movie original) {
        if (!allSet.contains(movie) && !movie.equals(original)) {
            allSet.add(movie);
            for (Movie similar : movie.getSimilarMovies()) {
                addAll(allSet, similar, original);
            }
        }
    }
}
