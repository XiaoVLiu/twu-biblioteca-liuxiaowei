package com.twu.biblioteca.model;

public class Book {

    public final String name;
    private final String author;
    private final int publishYear;
    public boolean isChecked;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String toString() {
        return "Name: " + this.name + ", Author: " + this.author + ", Publish Year: " + this.publishYear + "\n";
    }
}
