package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.router.MainMenuString;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;
import com.twu.biblioteca.router.handler.options.CheckoutBookOption;
import com.twu.biblioteca.router.handler.options.ListBooksOption;
import com.twu.biblioteca.router.handler.options.NullOptionHandler;

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
            return new NullOptionHandler(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("1")) {
            return new ListBooksOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("2")) {
            return new CheckoutBookOption(routerContext, bibliotecaService).handle(userInput);
        }

        if (userInput.equals("3")) {
            if (bibliotecaService.getCurrentUser() == null) {
                routerContext.setNextState(RouterState.Login);
                return new RouterMessage("please login!", true, false);
            }

            routerContext.setNextState(RouterState.ReturnBook);
            return new RouterMessage("", true, false);
        }

        if (userInput.equals("q")) {
            return new RouterMessage("", false, true);
        }

        if (userInput.equals("4")) {
            return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllMovies()), false, false);
        }

        if (userInput.equals("5")) {
            routerContext.setNextState(RouterState.CheckMovie);
            return new RouterMessage("", true, false);
        }

        if (userInput.equals("6")) {
            routerContext.setNextState(RouterState.Login);
            return new RouterMessage("", true, false);
        }

        if (userInput.equals("7")) {
            if (bibliotecaService.getCurrentUser() == null) {
                return new RouterMessage("Not available option!", false, false);
            }

            return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.getCurrentUser()), false, false);
        }

        return new RouterMessage("Select a valid option!", false, false);
    }
}
