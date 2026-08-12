package com.theconsistentcoder.java8.episode03;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDistinctLimitDemo {

    public static void main(String[] args) {
        System.out.println("-------------------");
        System.out.println("-------------------");

        List<Movie> movies = MovieData.getMovies();

        // sorted() — top 3 highest rated movies
        System.out.println("--- sorted() — top 3 by rating ---");
        List<Movie> top3 = movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(3)
                .collect(Collectors.toList());
        top3.forEach(m -> System.out.println(m.getTitle() + " - " + m.getRating()));

        // sorted() — top 3 longest movies
        System.out.println("\n--- sorted() — top 3 by duration ---");
        List<Movie> top3Longest = movies.stream()
                .sorted(Comparator.comparingInt(Movie::getDuration).reversed())
                .limit(3)
                .collect(Collectors.toList());
        top3Longest.forEach(m -> System.out.println(m.getTitle() + " - " + m.getDuration() + " mins"));

        // distinct() — unique genres
        System.out.println("\n--- distinct() — unique genres ---");
        List<String> genres = movies.stream()
                .map(Movie::getGenre)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(genres);

        //limit() — first 3 movies from list
        System.out.println("\n--- limit() — first 3 movies ---");
        List<String> first3 = movies.stream()
                .map(Movie::getTitle)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(first3);
    }
}
