package com.twu.biblioteca;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.router.BibliotecaRouter;
import com.twu.biblioteca.router.RouterState;
import com.twu.biblioteca.router.MainMenuString;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShellTests {
    @Test
    public void should_display_welcome_message_when_current_state_is_initialize() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Initialize, null);

        assertEquals("Welcome to Biblioteca!", bibliotecaRouter.getRouterMessage(null).getText());
    }

    @Test
    public void should_display_main_menu_when_current_state_is_main_menu() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, null);

        assertEquals(MainMenuString.getString(), bibliotecaRouter.getRouterMessage(null).getText());
    }

    @Test
    public void should_display_all_books_when_current_state_is_main_menu_and_user_select_list_books() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Xiaowei Liu", 1991));
        books.add(new Book("Book 2", "Xiao Liu", 2001));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(books, null));

        String expectedString = "Name: Book 1, Author: Xiaowei Liu, Publish Year: 1991\n" +
                "Name: Book 2, Author: Xiao Liu, Publish Year: 2001\n";

        assertEquals(expectedString, bibliotecaRouter.getRouterMessage("1").getText());
    }

    @Test
    public void should_return_invalid_message_when_user_not_select_list_books_in_main_menu_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, null);

        String invalidMessage = "Select a valid option!";
        assertEquals(invalidMessage, bibliotecaRouter.getRouterMessage("invalid option").getText());
    }

    @Test
    public void should_display_main_menu_when_continue_getRouterMessage_after_select_invalid_option_in_main_menu() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, null);
        bibliotecaRouter.getRouterMessage("invalid option");
        assertEquals(MainMenuString.getString(), bibliotecaRouter.getRouterMessage(null).getText());
    }

    @Test
    public void should_quit_when_user_select_quit_option_and_current_state_is_main_menu() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, null);

        assertTrue(bibliotecaRouter.getRouterMessage("q").getIsExit());
    }

    @Test
    public void should_waiting_for_user_input_when_user_select_checkout_book_in_main_menu_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, null);
        assertTrue(bibliotecaRouter.getRouterMessage("2").getWaitForUserInput());
    }

    @Test
    public void should_display_main_menu_when_continue_getRouterMessage_after_input_check_book_in_check_out_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.CheckBook, new BibliotecaService(new ArrayList<Book>(0), null));
        bibliotecaRouter.getRouterMessage("any book");

        assertEquals(MainMenuString.getString(), bibliotecaRouter.getRouterMessage(null).getText());
    }

    @Test
    public void should_display_all_unchecked_books_when_current_state_is_main_menu_and_user_select_list_books() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1, true));
        books.add(new Book("Book 2", "Author 2", 2, false));
        books.add(new Book("Book 3", "Author 3", 3, false));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(books, null));

        String expectedString = "Name: Book 2, Author: Author 2, Publish Year: 2\n" +
                "Name: Book 3, Author: Author 3, Publish Year: 3\n";

        assertEquals(expectedString, bibliotecaRouter.getRouterMessage("1").getText());
    }

    @Test
    public void should_display_enjoy_message_when_user_input_a_valid_book_name_in_checkout_book_state() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Anthor", 1));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.CheckBook, new BibliotecaService(books, null));

        assertEquals("Thank you! Enjoy the book", bibliotecaRouter.getRouterMessage("Book").getText());
    }

    @Test
    public void should_display_not_available_message_when_user_input_book_is_not_exist_in_checkout_book_state() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Anthor", 1));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.CheckBook, new BibliotecaService(books, null));

        assertEquals("That book is not available.", bibliotecaRouter.getRouterMessage("Invalid Book").getText());
    }

    @Test
    public void should_display_not_available_message_when_user_input_book_is_checked_out_in_checkout_book_state() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Anthor", 1, true));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.CheckBook, new BibliotecaService(books, null));

        assertEquals("That book is not available.", bibliotecaRouter.getRouterMessage("Book").getText());
    }

    @Test
    public void should_waiting_for_user_input_when_user_select_return_book_option_in_main_menu_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new ArrayList<Book>(0), null));

        assertTrue(bibliotecaRouter.getRouterMessage("3").getWaitForUserInput());
    }

    @Test
    public void should_display_main_menu_when_continue_getRouterMessage_after_input_return_book_in_return_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, new BibliotecaService(new ArrayList<Book>(0), null));
        bibliotecaRouter.getRouterMessage("any book");

        assertEquals(MainMenuString.getString(), bibliotecaRouter.getRouterMessage(null).getText());
    }

    @Test
    public void should_display_successful_message_when_user_input_a_valid_book_in_return_book_state() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book", "Anthor", 1, true));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, new BibliotecaService(books, null));

        assertEquals("Thank you for returning the book.", bibliotecaRouter.getRouterMessage("Book").getText());
    }

    @Test
    public void should_display_failed_message_when_user_input_unchecked_book_in_return_book_state() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Unchecked Book", "Anthor", 1, false));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, new BibliotecaService(books, null));

        assertEquals("That is not a valid book to return.", bibliotecaRouter.getRouterMessage("Unchecked Book").getText());
    }

    @Test
    public void should_display_failed_message_when_user_input_not_exist_book_in_return_book_state() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook,
                new BibliotecaService(new ArrayList<Book>(0), null));

        assertEquals("That is not a valid book to return.", bibliotecaRouter.getRouterMessage("Not Exist Book").getText());
    }

    @Test
    public void should_display_all_movies_when_select_list_movies_in_main_menu() throws Exception {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Movie 1", 1, "Director 1", 5, false));
        movies.add(new Movie("Movie 2", 2, "Director 2", 8, false));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(null, movies));

        String expectedString = "Name: Movie 1, Year: 1, Director: Director 1, Rate: 5\n" +
                "Name: Movie 2, Year: 2, Director: Director 2, Rate: 8\n" ;

        assertEquals(expectedString, bibliotecaRouter.getRouterMessage("4").getText());
    }

    @Test
    public void should_wait_for_input_when_select_cheout_movies_in_main_menu() throws Exception {
        assertTrue(new BibliotecaRouter(RouterState.MainMenu, null).getRouterMessage("5").getWaitForUserInput());
    }

    @Test
    public void should_display_main_menu_when_continue_getRouterMessage_after_input_movie_name_in_main_menu() throws Exception {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.CheckMovie, new BibliotecaService(null, new ArrayList<Movie>(0)));
        bibliotecaRouter.getRouterMessage("any movie");

        assertEquals(MainMenuString.getString(), bibliotecaRouter.getRouterMessage(null).getText());
    }

    @Test
    public void should_wait_for_input_when_select_login_in_main_menu() throws Exception {
        assertTrue(new BibliotecaRouter(RouterState.MainMenu, null).getRouterMessage("6").getWaitForUserInput());
    }
}
