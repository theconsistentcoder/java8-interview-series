package com.theconsistentcoder.java8.episode01;

public class Movie {

    private int id;
    private String title;
    private String genre;
    private double rating;
    private int year;
    private int duration;
    private boolean isAvailable;

    public Movie(int id, String title, String genre, double rating, int year, int duration, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
        this.duration = duration;
        this.isAvailable = isAvailable;
    }

    public int getId()           { return id; }
    public String getTitle()     { return title; }
    public String getGenre()     { return genre; }
    public double getRating()    { return rating; }
    public int getYear()         { return year; }
    public int getDuration()     { return duration; }
    public boolean isAvailable() { return isAvailable; }

    @Override
    public String toString() {
        return String.format("Movie{id=%d, title='%s', genre='%s', rating=%.1f, year=%d, duration=%d mins, available=%b}",
                id, title, genre, rating, year, duration, isAvailable);
    }
}
