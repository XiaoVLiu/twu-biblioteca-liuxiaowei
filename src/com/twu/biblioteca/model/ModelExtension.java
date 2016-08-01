package com.twu.biblioteca.model;

import java.util.ArrayList;

public class ModelExtension {
    public static String toFormattedString(ArrayList<Book> books) {
        String result = "";
        for (Book book : books) {
            result += book.toString();
        }

        return result;
    }
}
