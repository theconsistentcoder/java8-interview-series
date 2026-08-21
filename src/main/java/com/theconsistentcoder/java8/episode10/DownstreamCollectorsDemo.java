package com.theconsistentcoder.java8.episode10;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownstreamCollectorsDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        // joining() — all titles in one string
        String allTitles = movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println("All titles: " + allTitles);

        // joining() — with prefix and suffix
        String allTitlesFormatted = movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Formatted: " + allTitlesFormatted);

        // counting() — count per genre
        System.out.println();
        Map<String, Long> countByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        countByGenre.forEach((genre, count) -> System.out.println(genre + ": " + count + " movies"));

        // groupingBy() + averagingInt() — avg duration per genre
        System.out.println();
        Map<String, Double> avgDurationByGenre = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.averagingInt(Movie::getDuration)
                ));
        avgDurationByGenre.forEach((genre, avg) ->
                System.out.println(genre + ": " + avg + " mins avg"));

        // groupingBy() + averagingDouble() — avg rating per genre
        System.out.println();
        Map<String, Double> avgRatingByGenre = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.averagingDouble(Movie::getRating)
                ));
        avgRatingByGenre.forEach((genre, avg) ->
                System.out.println(genre + ": " + avg + " avg rating"));
    }
}
