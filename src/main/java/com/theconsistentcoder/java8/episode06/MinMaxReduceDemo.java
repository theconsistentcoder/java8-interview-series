package com.theconsistentcoder.java8.episode06;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxReduceDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        // min() — shortest movie
        Optional<Movie> shortest = movies.stream()
                .min(Comparator.comparingInt(Movie::getDuration));
        shortest.ifPresent(m -> System.out.println("Shortest: " + m.getTitle() + " - " + m.getDuration() + " mins"));

        // max() — longest movie
        Optional<Movie> longest = movies.stream()
                .max(Comparator.comparingInt(Movie::getDuration));
       longest.ifPresent(m -> System.out.println("Longest: " + m.getTitle() + " - " + m.getDuration() + " mins"));

        // max() — highest rated movie
        Optional<Movie> highestRated = movies.stream()
                .max(Comparator.comparingDouble(Movie::getRating));
     //   highestRated.ifPresent(m -> System.out.println("Highest rated: " + m.getTitle() + " - " + m.getRating()));

        // reduce() — total duration of all movies
        int totalDuration = movies.stream()
                .map(Movie::getDuration)
                .reduce(0, Integer::sum);
        System.out.println("Total duration: " + totalDuration + " mins");

        // reduce() — total duration in hours
        System.out.println("Total duration: " + totalDuration / 60 + " hrs " + totalDuration % 60 + " mins");
    }
}
