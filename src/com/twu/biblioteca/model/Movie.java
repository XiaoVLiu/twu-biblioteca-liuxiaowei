package com.twu.biblioteca.model;

public class Movie {
    private final String name;
    private final int year;
    private final String director;
    private final int rate;
    private boolean isChecked;

    public Movie(String name, int year, String director, int rate, boolean isChecked) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.isChecked = isChecked;
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

    public boolean getIsChecked() {
        return isChecked;
    }
}
