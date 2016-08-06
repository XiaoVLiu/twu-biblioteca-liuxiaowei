package com.twu.biblioteca.router.handler.options;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class CheckoutMovieOption implements IOptionHandlers {
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public CheckoutMovieOption(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.CheckMovie);
        return new RouterMessage("", true, false);
    }
}
