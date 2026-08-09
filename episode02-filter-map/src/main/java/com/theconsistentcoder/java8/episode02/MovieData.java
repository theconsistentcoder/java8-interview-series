package com.theconsistentcoder.java8.episode02;

import java.util.Arrays;
import java.util.List;

public class MovieData {

    public static List<Movie> getMovies() {
        return Arrays.asList(
            new Movie(1,  "Titanic",          "Romance",   7.8, 1997, 195, true),
            new Movie(2,  "Avatar",           "Sci-Fi",    7.9, 2009, 162, true),
            new Movie(3,  "Iron Man",         "Action",    7.9, 2008, 126, true),
            new Movie(4,  "The Lion King",    "Animation", 8.5, 1994,  88, true),
            new Movie(5,  "Joker",            "Drama",     8.4, 2019, 122, false),
            new Movie(6,  "Avengers",         "Action",    8.4, 2019, 181, true),
            new Movie(7,  "Frozen",           "Animation", 7.5, 2013, 102, false),
            new Movie(8,  "Spider-Man",       "Action",    7.4, 2002, 121, true),
            new Movie(9,  "The Dark Knight",  "Action",    9.0, 2008, 152, true),
            new Movie(10, "Forrest Gump",     "Drama",     8.8, 1994, 142, false)
        );
    }
}
