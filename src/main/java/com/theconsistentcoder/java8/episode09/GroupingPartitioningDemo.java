package com.theconsistentcoder.java8.episode09;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingPartitioningDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();
        System.out.println("------------");
        System.out.println("------------");

        // groupingBy() — group by genre
        Map<String, List<Movie>> byGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        byGenre.forEach((genre, list) ->
                System.out.println(genre + ": " +
                        list.stream().map(Movie::getTitle).collect(Collectors.toList())));

        // groupingBy() — group by year
        System.out.println();
        Map<Integer, List<String>> byYear = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getYear,
                        Collectors.mapping(Movie::getTitle, Collectors.toList())
                ));
        byYear.forEach((year, titles) -> System.out.println(year + ": " + titles));

        // partitioningBy() — available vs not available
        System.out.println();
        Map<Boolean, List<Movie>> byAvailability = movies.stream()
                .collect(Collectors.partitioningBy(Movie::isAvailable));

       System.out.println("Available: " +
              byAvailability.get(true).stream().map(Movie::getTitle).collect(Collectors.toList()));
       System.out.println("Not Available: " +
              byAvailability.get(false).stream().map(Movie::getTitle).collect(Collectors.toList()));

        // partitioningBy() — rating above 8
        System.out.println();
        Map<Boolean, List<String>> byRating = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getRating() > 8.0,
                        Collectors.mapping(Movie::getTitle, Collectors.toList())
                ));
       System.out.println("Rating > 8 : " + byRating.get(true));
        System.out.println("Rating <= 8: " + byRating.get(false));
    }
}
