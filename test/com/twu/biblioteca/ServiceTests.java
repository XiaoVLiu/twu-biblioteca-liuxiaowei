package com.twu.biblioteca;


import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
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
        ArrayList<Book> books = createBooks();

        assertEquals(books, new BibliotecaService(books).listAllBooks());
    }

    public ArrayList<Book> createBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Xiaowei Liu", 1991));
        books.add(new Book("Book 2", "Xiao Liu", 2001));
        return books;
    }

    @Test
    public void should_return_true_when_book_is_unchecked_and_exist() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Author", 1));
        BibliotecaService bibliotecaService = new BibliotecaService(books);

        assertTrue(bibliotecaService.checkoutBook("Book"));
    }
}
