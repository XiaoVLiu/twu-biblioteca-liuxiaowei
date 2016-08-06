package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.handler.options.*;

public class MainMenuHandler  implements IActionHandler{
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public MainMenuHandler(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        if (userInput == null) {
            return new NullOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("1")) {
            return new ListBooksOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("2")) {
            return new CheckoutBookOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("3")) {
            return new ReturnBookOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("q")) {
            return new QuitOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("4")) {
            return new ListMoviesOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("5")) {
            return new CheckoutMovieOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("6")) {
            return new ReturnMovieOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("7")) {
            return new UserInfoOption(routerContext, bibliotecaService).handle(userInput);
        }

        return new RouterMessage("Select a valid option!", false, false);
    }
}
