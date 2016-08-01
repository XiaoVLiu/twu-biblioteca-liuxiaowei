package com.twu.biblioteca.router;

import com.twu.biblioteca.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.source.MainMenuString;

public class BibliotecaRouter {
    private final RouterState routerState;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerState = routerState;
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage(String option) {
        if (routerState == RouterState.Initialize) {
            return new RouterMessage("Welcome to Biblioteca!");
        }
        else if (routerState == RouterState.MainMenu) {
            if (option == "1") {
                return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()));
            }
            else {
                return new RouterMessage("Select a valid option!");
            }
        }

        return new RouterMessage(MainMenuString.getString());
    }

    public String showMainMenu() {
        return MainMenuString.getString();
    }
}
