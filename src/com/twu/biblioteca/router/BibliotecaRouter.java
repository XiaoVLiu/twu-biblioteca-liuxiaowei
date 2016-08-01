package com.twu.biblioteca.router;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;

public class BibliotecaRouter {
    private RouterState routerState;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerState = routerState;
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage(String option) throws Exception {
        if (routerState == RouterState.Initialize) {
            return new RouterMessage("Welcome to Biblioteca!", false, false);
        }
        else if (routerState == RouterState.MainMenu) {
            if (option == null) {
                return new RouterMessage(MainMenuString.getString(), true, false);
            }
            if (option == "1") {
                return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()), false, false);
            } else if (option == "2") {
                return new RouterMessage("", true, false);
            }
            else if (option == "4") {
                return new RouterMessage("", false, true);
            }
            else {
                return new RouterMessage("Select a valid option!", false, false);
            }
        } else if (routerState == RouterState.CheckBook) {
            routerState = RouterState.MainMenu;
            return new RouterMessage("", false, false);
        }

        throw new Exception("Invalid router state!");
    }

    public static RouterMessage getRouterMessage2(BibliotecaRouter bibliotecaRouter, String option) throws Exception {
        if (bibliotecaRouter.routerState == RouterState.Initialize) {
            return new RouterMessage("Welcome to Biblioteca!", false, false);
        }
        else if (bibliotecaRouter.routerState == RouterState.MainMenu) {
            if (option == null) {
                return new RouterMessage(MainMenuString.getString(), true, false);
            }
            if (option == "1") {
                return new RouterMessage(ModelExtension.toFormattedString(bibliotecaRouter.bibliotecaService.listAllBooks()), false, false);
            } else if (option == "2") {
                return new RouterMessage("", true, false);
            }
            else if (option == "4") {
                return new RouterMessage("", false, true);
            }
            else {
                return new RouterMessage("Select a valid option!", false, false);
            }
        } else if (bibliotecaRouter.routerState == RouterState.CheckBook) {
            bibliotecaRouter.routerState = RouterState.MainMenu;
            return new RouterMessage("", false, false);
        }

        throw new Exception("Invalid router state!");
    }
}
