package com.theconsistentcoder.java8.episode07;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class PrimitiveStreamsDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        System.out.println("---------------------------");
        System.out.println("---------------------------");
        // mapToInt() + sum() — total duration
        int totalDuration = movies.stream()
                .mapToInt(Movie::getDuration)
                .sum();
        System.out.println("Total duration: " + totalDuration + " mins");

        // mapToInt() + min() + max()
        int shortest = movies.stream()
                .mapToInt(Movie::getDuration)
                .min()
                .getAsInt();
        System.out.println("Shortest: " + shortest + " mins");

        int longest = movies.stream()
                .mapToInt(Movie::getDuration)
                .max()
                .getAsInt();
        System.out.println("Longest: " + longest + " mins");

        // mapToDouble() + average() — average rating
        OptionalDouble avgRating = movies.stream()
                .mapToDouble(Movie::getRating)
                .average();
        avgRating.ifPresent(r -> System.out.println("Average rating: " + r));

        // summarizingInt() — all stats in one call
        IntSummaryStatistics stats = movies.stream()
                .collect(Collectors.summarizingInt(Movie::getDuration));
        System.out.println("\n--- Duration Stats ---");
        System.out.println("Count   : " + stats.getCount());
        System.out.println("Sum     : " + stats.getSum() + " mins");
        System.out.println("Min     : " + stats.getMin() + " mins");
        System.out.println("Max     : " + stats.getMax() + " mins");
        System.out.println("Average : " + stats.getAverage() + " mins");
    }
}
