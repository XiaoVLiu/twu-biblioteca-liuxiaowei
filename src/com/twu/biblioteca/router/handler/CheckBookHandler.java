package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class CheckBookHandler implements IActionHandler{
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public CheckBookHandler(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.MainMenu);

        if (bibliotecaService.checkoutBook(userInput)) {
            return new RouterMessage("Thank you! Enjoy the book", false, false);
        }

        return new RouterMessage("That book is not available.", false, false);
    }
}
