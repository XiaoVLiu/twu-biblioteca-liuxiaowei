package com.twu.biblioteca.router.handler.options;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class ReturnMovieOption implements IOptionHandlers{
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public ReturnMovieOption(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.Login);
        return new RouterMessage("", true, false);
    }
}
