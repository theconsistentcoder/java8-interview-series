package com.theconsistentcoder.java8.episode01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        // Way 1: stream() — from a List
        System.out.println("--- Way 1: stream() ---");
        Stream<Movie> s1 = movies.stream();
        s1.forEach(m -> System.out.println(m.getTitle() + " (" + m.getYear() + ")"));

        // Way 2: Stream.of() — from individual objects
        System.out.println("\n--- Way 2: Stream.of() ---");
        Stream<Movie> s2 = Stream.of(
                new Movie(1, "Titanic", "Romance", 7.8, 1997, 195, true),
                new Movie(2, "Avatar",  "Sci-Fi",  7.9, 2009, 162, true)
        );
        s2.forEach(m -> System.out.println(m.getTitle() + " | Genre: " + m.getGenre()));

        // Way 3: Arrays.stream() — from an array
        System.out.println("\n--- Way 3: Arrays.stream() ---");
        Movie[] movieArray = movies.toArray(new Movie[0]);
        Stream<Movie> s3 = Arrays.stream(movieArray);
        s3.forEach(m -> System.out.println(m.getTitle() + " | Duration: " + m.getDuration() + " mins"));
    }
}
