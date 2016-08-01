package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class ReturnBookHandler implements IActionHandler{
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public ReturnBookHandler(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.MainMenu);
        if (bibliotecaService.returnBook(userInput)) {
            return new RouterMessage("Thank you for returning the book.", false, false);
        } else {
            return new RouterMessage("That is not a valid book to return.", false, false);
        }
    }
}
