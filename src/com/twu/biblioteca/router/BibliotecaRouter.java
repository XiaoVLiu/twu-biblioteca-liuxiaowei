package com.twu.biblioteca.router;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;

public class BibliotecaRouter {
    private RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerContext = new RouterContext(routerState);
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage(String userInput) throws Exception {
        if (routerContext.getCurrentState() == RouterState.Initialize) {
            return new RouterMessage("Welcome to Biblioteca!", false, false);
        }
        else if (routerContext.getCurrentState() == RouterState.MainMenu) {
            if (userInput == null) {
                return new RouterMessage(MainMenuString.getString(), true, false);
            } else if (userInput == "1") {
                return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()), false, false);
            } else if (userInput == "2") {
                routerContext.setNextState(RouterState.CheckBook);
                return new RouterMessage("", true, false);
            } else if (userInput == "3") {
                return new RouterMessage("", true, false);
            } else if (userInput == "4") {
                return new RouterMessage("", false, true);
            } else {
                return new RouterMessage("Select a valid option!", false, false);
            }
        } else if (routerContext.getCurrentState() == RouterState.CheckBook) {
            routerContext.setNextState(RouterState.MainMenu);

            if (bibliotecaService.checkoutBook(userInput)) {
                return new RouterMessage("Thank you! Enjoy the book", false, false);
            } else {
                return new RouterMessage("That book is not available.", false, false);
            }
        } else if (routerContext.getCurrentState() == RouterState.ReturnBook) {
            routerContext.setNextState(RouterState.MainMenu);
            if (bibliotecaService.returnBook(userInput)) {
                return new RouterMessage("Thank you for returning the book.", false, false);
            } else {
                return new RouterMessage("That is not a valid book to return.", false, false);
            }
        }

        throw new Exception("Invalid router state!");
    }
}
