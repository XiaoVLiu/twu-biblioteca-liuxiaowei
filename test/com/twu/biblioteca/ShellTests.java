package com.twu.biblioteca;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.router.BibliotecaRouter;
import com.twu.biblioteca.router.RouterState;
import com.twu.biblioteca.source.MainMenuString;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShellTests {
    @Test
    public void should_display_welcome_message_when_current_state_is_initialize() throws Exception {
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
    public void should_display_all_books_when_current_state_is_main_menu_and_user_select_list_books() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Xiaowei Liu", 1991));
        books.add(new Book("Book 2", "Xiao Liu", 2001));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(books));

        String expectedString = "Name: Book 1, Author: Xiaowei Liu, Publish Year: 1991\n" +
                "Name: Book 2, Author: Xiao Liu, Publish Year: 2001\n";

        assertEquals(expectedString, bibliotecaRouter.getRouterMessage("1").text);
    }

    @Test
    public void should_return_invalid_message_when_user_not_select_list_books_in_main_menu_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(null));

        String invalidMessage = "Select a valid option!";
        assertEquals(invalidMessage, bibliotecaRouter.getRouterMessage("invalid option").text);
    }

    @Test
    public void should_display_main_menu_when_continue_getRouterMessage_after_select_invalid_option_in_main_menu() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(null));
        bibliotecaRouter.getRouterMessage("invalid option");
        assertEquals(MainMenuString.getString(), bibliotecaRouter.getRouterMessage(null).text);
    }

    @Test
    public void should_quit_when_user_select_quit_option_and_current_state_is_main_menu() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, null);

        assertTrue(bibliotecaRouter.getRouterMessage("4").isExit);
    }
}
