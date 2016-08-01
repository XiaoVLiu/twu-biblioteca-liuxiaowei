package com.twu.biblioteca.router;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.source.MainMenuString;

public class BibliotecaRouter {
    private final RouterState routerState;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerState = routerState;
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage(String option) throws Exception {
        if (routerState == RouterState.Initialize) {
            return new RouterMessage("Welcome to Biblioteca!");
        }
        else if (routerState == RouterState.MainMenu) {
            if (option == null) {
                return new RouterMessage(MainMenuString.getString());
            }
            if (option == "1") {
                return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()));
            }
            else {
                return new RouterMessage("Select a valid option!");
            }
        }

        throw new Exception("Invalid state!");
    }

    public String showMainMenu() {
        return MainMenuString.getString();
    }
}
