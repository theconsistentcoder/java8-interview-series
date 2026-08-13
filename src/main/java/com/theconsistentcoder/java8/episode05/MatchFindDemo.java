package com.theconsistentcoder.java8.episode05;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.List;
import java.util.Optional;

public class MatchFindDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        // anyMatch() — is any movie rated above 9?
        boolean anyAbove9 = movies.stream()
                .anyMatch(m -> m.getRating() > 9.0);
       System.out.println("Any rated above 9? " + anyAbove9);

        // allMatch() — are all movies available?
        boolean allAvailable = movies.stream()
                .allMatch(Movie::isAvailable);
       System.out.println("All available? " + allAvailable);

        // noneMatch() — does none run under 80 mins?
        boolean noneUnder80 = movies.stream()
                .noneMatch(m -> m.getDuration() < 80);
        System.out.println("None under 80 mins? " + noneUnder80);

        // findFirst() — first Action movie
        Optional<Movie> firstAction = movies.stream()
                .filter(m -> m.getGenre().equals("Action"))
                .findFirst();
        firstAction.ifPresent(m -> System.out.println("First Action: " + m.getTitle()));
    }
}
