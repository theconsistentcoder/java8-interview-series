package com.theconsistentcoder.java8.episode01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * =====================================================================
 * Episode 01 — Stream Creation
 * Series: Java 8 Interview Series | @theconsistentcoder
 * =====================================================================
 *
 * Methods Covered:
 *   stream()         — create a stream from a List or Collection
 *   Stream.of()      — create a stream from individual objects
 *   Arrays.stream()  — create a stream from an array
 *
 * Domain: Movie
 * Fields: id, title, genre, rating, year, duration (mins), isAvailable
 * =====================================================================
 */
public class StreamCreationDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        System.out.println("===========================================================");
        System.out.println("  Episode 01 — 3 Ways to Create a Stream in Java 8");
        System.out.println("===========================================================\n");

        // -----------------------------------------------------------------
        // WAY 1: stream()
        // Called directly on any List or Collection.
        // Most common — use this 90% of the time.
        // -----------------------------------------------------------------
        System.out.println("--- Way 1: stream() from a List ---");

        Stream<Movie> s1 = movies.stream();
        s1.forEach(m -> System.out.println("  " + m.getTitle() + " (" + m.getYear() + ")"));

        // -----------------------------------------------------------------
        // WAY 2: Stream.of()
        // Pass individual objects directly.
        // Great for unit tests and quick demos without a full list.
        // -----------------------------------------------------------------
        System.out.println("\n--- Way 2: Stream.of() from individual objects ---");

        Stream<Movie> s2 = Stream.of(
                new Movie(1, "Titanic", "Romance", 7.8, 1997, 195, true),
                new Movie(2, "Avatar",  "Sci-Fi",  7.9, 2009, 162, true)
        );
        s2.forEach(m -> System.out.println("  " + m.getTitle() + " | Genre: " + m.getGenre()));

        // -----------------------------------------------------------------
        // WAY 3: Arrays.stream()
        // When your data is in an array, not a List.
        // Common in legacy codebases that still use arrays.
        // -----------------------------------------------------------------
        System.out.println("\n--- Way 3: Arrays.stream() from an array ---");

        Movie[] movieArray = movies.toArray(new Movie[0]);
        Stream<Movie> s3 = Arrays.stream(movieArray);
        s3.forEach(m -> System.out.println("  " + m.getTitle() + " | Duration: " + m.getDuration() + " mins"));

        // -----------------------------------------------------------------
        // KEY TAKEAWAYS
        // -----------------------------------------------------------------
        System.out.println("\n===========================================================");
        System.out.println("  Key Takeaways:");
        System.out.println("  1. stream()         → use with List or Collection");
        System.out.println("  2. Stream.of()      → use with individual objects");
        System.out.println("  3. Arrays.stream()  → use with arrays");
        System.out.println();
        System.out.println("  A Stream is NOT a data structure.");
        System.out.println("  It is a pipeline — use it once, done.");
        System.out.println("  Reuse it → IllegalStateException.");
        System.out.println("===========================================================");
    }
}
