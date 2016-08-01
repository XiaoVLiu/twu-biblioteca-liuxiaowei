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
        ArrayList<Book> showBooks = new ArrayList<Book>();

        for (Book book : allBooks) {
            if (!book.getIsChecked()) {
                showBooks.add(book);
            }
        }

        return showBooks;
    }

    public boolean checkoutBook(String checkoutBookName) {
        for (Book book: allBooks) {
            if (book.getName().equals(checkoutBookName) && !book.getIsChecked()) {
                book.setIsChecked(true);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(String returnBookName) {
        for (Book book : allBooks) {
            if (book.getName().equals(returnBookName) && book.getIsChecked()) {
                book.setIsChecked(false);
                return true;
            }
        }

        return false;
    }
}
