package com.twu.biblioteca.model;

import com.twu.biblioteca.fixtures.UserFixture;

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

    public static String toFormattedString(String currentUserLibraryNumber) {
        UserInfo userInfo = UserFixture.loadAllUsers().get(currentUserLibraryNumber);

        return "Library Number: " + userInfo.getLibraryNumber() +
                ", Name: " + userInfo.getName() +
                ", Email Address: " + userInfo.getEmail() +
                ", Phone Number: " + userInfo.getPhoneNumber() +
                "\n";
    }
}
