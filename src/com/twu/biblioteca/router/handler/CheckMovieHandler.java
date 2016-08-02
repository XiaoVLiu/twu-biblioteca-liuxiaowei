package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class CheckMovieHandler implements IActionHandler {
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public CheckMovieHandler(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.MainMenu);
        bibliotecaService.checkoutMovie(userInput);

        return new RouterMessage("", false, false);
    }
}
