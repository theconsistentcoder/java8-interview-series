package com.theconsistentcoder.java8.episode08;

import com.theconsistentcoder.java8.episode01.Movie;
import com.theconsistentcoder.java8.episode01.MovieData;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsBasicsDemo {

    public static void main(String[] args) {

        List<Movie> movies = MovieData.getMovies();

        // toList() — collect titles to a List
        List<String> titleList = movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        System.out.println("List: " + titleList);

        // toSet() — collect genres to a Set (duplicates removed)
        Set<String> genreSet = movies.stream()
                .map(Movie::getGenre)
                .collect(Collectors.toSet());
        System.out.println("Set: " + genreSet);

        // toMap() — id -> title
        Map<Integer, String> movieMap = movies.stream()
                .collect(Collectors.toMap(Movie::getId, Movie::getTitle));
        System.out.println("Map: " + movieMap);

        // toMap() — title -> rating
        Map<String, Double> ratingMap = movies.stream()
                .collect(Collectors.toMap(Movie::getTitle, Movie::getRating));
        System.out.println("Rating Map: " + ratingMap);
    }
}
