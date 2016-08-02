package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;

public class BibliotecaService {
    private ArrayList<Book> allBooks;
    private ArrayList<Movie> allMovies;
    private String currentUser = null;

    public BibliotecaService(ArrayList<Book> allBooks, ArrayList<Movie> allMovies) {
        this.allBooks = allBooks;
        this.allMovies = allMovies;
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
        if (currentUser == null) {
            return false;
        }

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

    public ArrayList<Movie> listAllMovies() {
        return allMovies;
    }

    public boolean checkoutMovie(String checkoutMovieName) {
        for (Movie movie : allMovies) {
            if (movie.getName().equals(checkoutMovieName) && !movie.getIsChecked()) {
                return true;
            }
        }

        return false;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
