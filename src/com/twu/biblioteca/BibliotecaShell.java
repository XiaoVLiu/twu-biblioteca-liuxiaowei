package com.twu.biblioteca;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.router.BibliotecaRouter;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaShell {
    private final PrintStream out;
    private final InputStream in;

    public BibliotecaShell(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    public void execute() throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        books.add(new Book("Book 3", "Author 3", 3));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Initialize, new BibliotecaService(books));

        String userInput = null;
        while (true) {

            RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(userInput);
            out.println(routerMessage.getText());

            if (routerMessage.getIsExit()) {
                break;
            }

            if (routerMessage.getWaitForUserInput()) {
                userInput = new Scanner(in).nextLine();
            } else {
                userInput = null;
            }
        }
    }
}
