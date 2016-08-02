package com.twu.biblioteca.model;

public class Book {

    private final String name;
    private final String author;
    private final int publishYear;
    private boolean isChecked;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public Book(String name, String author, int publishYear, boolean isChecked) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }
}
