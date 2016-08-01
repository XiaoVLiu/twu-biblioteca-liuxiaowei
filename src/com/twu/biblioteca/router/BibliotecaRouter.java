package com.twu.biblioteca.router;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.router.handler.CheckBookHandler;
import com.twu.biblioteca.router.handler.InitialHandler;
import com.twu.biblioteca.router.handler.MainMenuHandler;
import com.twu.biblioteca.router.handler.ReturnBookHandler;

public class BibliotecaRouter {
    private RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerContext = new RouterContext(routerState);
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage(String userInput) throws Exception {
        switch (routerContext.getCurrentState()) {
            case Initialize:
                return new InitialHandler(routerContext).handle(userInput);
            case MainMenu:
                return new MainMenuHandler(routerContext, bibliotecaService).handle(userInput);
            case CheckBook:
                return new CheckBookHandler(routerContext, bibliotecaService).handle(userInput);
            case ReturnBook:
                return new ReturnBookHandler(routerContext, bibliotecaService).handle(userInput);
        }

        throw new Exception("Invalid router state!");
    }
}

