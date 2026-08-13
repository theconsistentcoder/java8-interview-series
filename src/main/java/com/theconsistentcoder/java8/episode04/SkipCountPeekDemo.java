package com.theconsistentcoder.java8.episode04;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.List;
import java.util.stream.Collectors;

public class SkipCountPeekDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        // skip() — skip first 5 movies
        System.out.println("--- skip() — skip first 5 ---");
        List<String> skipped = movies.stream()
                .map(Movie::getTitle)
                .skip(5)
                .collect(Collectors.toList());
      // System.out.println(skipped);

        // count() — count available movies
        //System.out.println("\n--- count() — available movies ---");
        long availableCount = movies.stream()
                .filter(Movie::isAvailable)
                .count();
      //  System.out.println("Available movies: " + availableCount);

        // peek() — debug mid-pipeline
       // System.out.println("\n--- peek() — debug pipeline ---");
        List<String> result = movies.stream()
                .filter(Movie::isAvailable)
             //   .peek(m -> System.out.println("After filter: " + m.getTitle()))
                .filter(m -> m.getRating() > 8.0)
               // .peek(m -> System.out.println("After rating filter: " + m.getTitle()))
                .map(Movie::getTitle)
                .collect(Collectors.toList());
       // System.out.println("Final result: " + result);

        // skip() + limit() — pagination
        System.out.println("\n--- skip() + limit() — page 2 (3 per page) ---");
        List<String> page2 = movies.stream()
                .map(Movie::getTitle)
                .skip(3)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Page 2: " + page2);
    }
}
