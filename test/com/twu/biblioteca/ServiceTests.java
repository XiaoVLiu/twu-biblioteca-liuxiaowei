package com.twu.biblioteca;


import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.router.BibliotecaRouter;
import com.twu.biblioteca.router.RouterState;
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
    public void should_list_all_books_when_call_listAllBooks(){
        ArrayList<Book> books = createBooks();

        assertEquals(books, new BibliotecaService(books).listAllBooks());
    }

    private ArrayList<Book> createBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Xiaowei Liu", 1991));
        books.add(new Book("Book 2", "Xiao Liu", 2001));
        return books;
    }

    @Test
    public void should_display_welcome_message_when_current_state_is_initialize() {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Initialize, new BibliotecaService(null));

        assertEquals("Welcome to Biblioteca!", bibliotecaRouter.getRouterMessage(null).text);
    }

    @Test
    public void should_display_main_menu_when_current_state_is_main_menu() {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(null));

        String expectedString = "************Main Menu************\n" +
                "1. List Books\n" +
                "*********************************\n";
        assertEquals(expectedString, bibliotecaRouter.showMainMenu());
    }

    @Test
    public void should_display_all_books_when_current_state_is_main_menu_and_user_select_list_books() {
        ArrayList<Book> books = createBooks();
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(books));

        String expectedString = "Name: Book 1, Author: Xiaowei Liu, Publish Year: 1991\n" +
                "Name: Book 2, Author: Xiao Liu, Publish Year: 2001\n";

        assertEquals(expectedString, bibliotecaRouter.getRouterMessage("1").text);
    }

    @Test
    public void should_return_invalid_message_when_user_not_select_list_books_in_main_menu_state() {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(null));

        String invalidMessage = "Select a valid option!";
        assertEquals(invalidMessage, bibliotecaRouter.getRouterMessage("invalid option").text);
    }
}