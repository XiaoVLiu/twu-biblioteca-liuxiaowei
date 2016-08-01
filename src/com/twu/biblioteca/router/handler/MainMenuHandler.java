package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.router.MainMenuString;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

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
            return new RouterMessage(MainMenuString.getString(), true, false);
        } else if (userInput.equals("1")) {
            return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()), false, false);
        } else if (userInput.equals("2")) {
            routerContext.setNextState(RouterState.CheckBook);
            return new RouterMessage("", true, false);
        } else if (userInput.equals("3")) {
            routerContext.setNextState(RouterState.ReturnBook);
            return new RouterMessage("", true, false);
        } else if (userInput.equals("4")) {
            return new RouterMessage("", false, true);
        } else {
            return new RouterMessage("Select a valid option!", false, false);
        }
    }
}
