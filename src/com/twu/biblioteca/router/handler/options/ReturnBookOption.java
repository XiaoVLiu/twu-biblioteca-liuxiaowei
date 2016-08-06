package com.twu.biblioteca.router.handler.options;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class ReturnBookOption implements IOptionHandlers {
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public ReturnBookOption(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {

        if (bibliotecaService.getCurrentUser() == null) {
            routerContext.setNextState(RouterState.Login);
            return new RouterMessage("please login!", true, false);
        }

        routerContext.setNextState(RouterState.ReturnBook);
        return new RouterMessage("", true, false);
    }
}
