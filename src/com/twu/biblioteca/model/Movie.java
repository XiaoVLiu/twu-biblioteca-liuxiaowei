package com.twu.biblioteca.model;

public class Movie {
    private final String name;
    private final int year;
    private final String director;
    private final int rate;

    public Movie(String name, int year, String director, int rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRate() {
        return rate;
    }
}
