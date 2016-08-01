package com.twu.biblioteca;


import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
    public void should_list_books_when_call_listAllBooks(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1"));
        books.add(new Book("Book 2"));

        assertEquals(books, new BibliotecaService(books).listAllBooks());
    }
}
