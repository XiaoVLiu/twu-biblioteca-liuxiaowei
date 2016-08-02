package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class ModelExtension {
    public static String toFormattedString(ArrayList<Book> books) {
        String result = "";
        for (Book book : books) {
            result += "Name: " + book.getName() + ", Author: " + book.getAuthor() + ", Publish Year: " +
                    book.getPublishYear() + "\n";
        }

        return result;
    }

    public static String toFormattedString(List<Movie> movies) {
        String result = "";
        for (Movie movie : movies) {
            result += "Name: " + movie.getName() + ", Year: " + movie.getYear() + ", Director: " +
                    movie.getDirector() + ", Rate: " + movie.getRate() + "\n";
        }

        return result;
    }
}
