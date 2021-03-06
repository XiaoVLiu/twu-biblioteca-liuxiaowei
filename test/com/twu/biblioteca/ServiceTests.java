package com.twu.biblioteca;


import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServiceTests {
    private ByteArrayOutputStream output;
    private PrintStream console;

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        console = new PrintStream(output);
    }

    @Test
    public void should_return_welcome_message_when_call_getWelcomeMessage(){
        String welcomeMessage = "Welcome to Biblioteca!";
        assertEquals(welcomeMessage, BibliotecaService.getWelcomeMessage());
    }

    @Test
    public void should_list_all_books_when_call_listAllBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Xiaowei Liu", 1991));
        books.add(new Book("Book 2", "Xiao Liu", 2001));

        assertEquals(books, new BibliotecaService(books, null).listAllBooks());
    }

    @Test
    public void should_return_true_when_book_is_unchecked_and_exist() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Author", 1));
        BibliotecaService bibliotecaService = new BibliotecaService(books, null);
        bibliotecaService.setCurrentUser("001-0000");

        assertTrue(bibliotecaService.checkoutBook("Book"));
    }

    @Test
    public void should_return_false_when_book_is_not_exist() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Author", 1));
        BibliotecaService bibliotecaService = new BibliotecaService(books, null);

        assertFalse(bibliotecaService.checkoutBook("Invalid Book"));
    }

    @Test
    public void should_return_false_when_book_is_checked_out() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Checked Book", "Author", 1, true));
        BibliotecaService bibliotecaService = new BibliotecaService(books, null);

        assertFalse(bibliotecaService.checkoutBook("Checked Book"));
    }

    @Test
    public void should_list_unchecked_books_when_call_listAllBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1, true));
        books.add(new Book("Book 2", "Author 2", 2, false));
        books.add(new Book("Book 3", "Author 3", 3, true));

        assertEquals(books.subList(1, 2), new BibliotecaService(books, null).listAllBooks());
    }

    @Test
    public void should_return_true_when_checked_user_return_his_book() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Book", "Author", 1, true);
        books.add(book);
        book.setCheckedUser("001-0000");

        BibliotecaService bibliotecaService = new BibliotecaService(books, null);
        bibliotecaService.setCurrentUser("001-0000");

        assertTrue(bibliotecaService.returnBook("Book"));
    }

    @Test
    public void should_return_false_when_return_unchecked_book() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Unchecked Book", "Author", 1, false));

        assertFalse(new BibliotecaService(books, null).returnBook("Unchecked Book"));
    }

    @Test
    public void should_return_false_when_return_a_not_exist_book() {
        assertFalse(new BibliotecaService(new ArrayList<Book>(0), null).returnBook("Not Exist Book"));
    }

    @Test
    public void should_return_all_movies_when_call_list_movies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Movie 1", 1, "Director 1", 5, false));
        movies.add(new Movie("Movie 2", 2, "Director 2", 8, false));

        assertEquals(movies, new BibliotecaService(null, movies).listAllMovies());
    }

    @Test
    public void should_return_true_when_checkout_a_valid_movie_name() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Movie", 1, "Director", 5, false));

        assertTrue(new BibliotecaService(null, movies).checkoutMovie("Movie"));
    }

    @Test
    public void should_return_false_when_checkout_a_checked_movie_name() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Movie", 1, "Director", 5, true));

        assertFalse(new BibliotecaService(null, movies).checkoutMovie("Movie"));
    }

    @Test
    public void should_return_false_when_checkout_a_not_exist_movie_name() {
        assertFalse(new BibliotecaService(null, new ArrayList<Movie>(0)).checkoutMovie("Movie"));
    }

    @Test
    public void should_return_false_when_checkout_book_but_not_loged_in() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Author", 1));

        assertFalse(new BibliotecaService(books, null).checkoutBook("Book"));
    }

    @Test
    public void should_return_false_when_return_book_but_not_loged_in() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Book", "Author", 1, true);
        books.add(book);
        book.setCheckedUser("001-0000");

        assertFalse(new BibliotecaService(books, null).returnBook("Book"));
    }

    @Test
    public void should_return_false_when_another_user_return_the_book() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Book", "Author", 1, true);
        books.add(book);
        book.setCheckedUser("001-0000");

        BibliotecaService bibliotecaService = new BibliotecaService(books, null);
        bibliotecaService.setCurrentUser("002-0000");

        assertFalse(bibliotecaService.returnBook("Book"));
    }
}
