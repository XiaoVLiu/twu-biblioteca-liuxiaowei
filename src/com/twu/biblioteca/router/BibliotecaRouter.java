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
            }
            if (userInput == "1") {
                return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()), false, false);
            } else if (userInput == "2") {
                return new RouterMessage("", true, false);
            }
            else if (userInput == "4") {
                return new RouterMessage("", false, true);
            }
            else {
                return new RouterMessage("Select a valid option!", false, false);
            }
        } else if (routerContext.getCurrentState() == RouterState.CheckBook) {
            routerContext.setNextState(RouterState.MainMenu);

            if (bibliotecaService.checkoutBook(userInput)) {
                return new RouterMessage("Thank you! Enjoy the book", false, false);
            }
            return new RouterMessage("", false, false);
        }

        throw new Exception("Invalid router state!");
    }
}
