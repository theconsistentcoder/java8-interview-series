package com.theconsistentcoder.java8.episode02;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.List;
import java.util.stream.Collectors;

public class FilterMapDemo {

    public static void main(String[] args) {
        System.out.println("-------------------");
        System.out.println("-------------------");
        List<Movie> movies = MovieData.getMovies();

        // filter() — keep only Action movies
        // map() — extract just the title
        List<String> actionTitles = movies.stream()
                .filter(m -> m.getGenre().equals("Action"))
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        System.out.println("Action movies: " + actionTitles);

        // filter() — available movies with rating above 8
        // map() — extract title and rating
        List<String> topAvailable = movies.stream()
                .filter(Movie::isAvailable)
                .filter(m -> m.getRating() > 8.0)
                .map(m -> m.getTitle() + " (" + m.getRating() + ")")
                .collect(Collectors.toList());

        System.out.println("Top available: " + topAvailable);
    }
}
