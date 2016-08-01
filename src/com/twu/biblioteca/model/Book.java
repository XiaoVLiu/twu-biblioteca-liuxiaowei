package com.twu.biblioteca.model;

public class Book {

    private final String name;
    private final String author;
    private final int publishYear;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }
}
