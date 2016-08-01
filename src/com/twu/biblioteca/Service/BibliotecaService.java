package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

public class BibliotecaService {
    private ArrayList<Book> allBooks;

    public BibliotecaService(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public ArrayList<Book> listAllBooks() {
        return allBooks;
    }

    public boolean checkoutBook(String checkoutBookName) {
        for (Book book: allBooks) {
            if (book.name == checkoutBookName && book.isChecked == false) {
                book.isChecked = true;
                return true;
            }
        }

        return false;
    }
}
