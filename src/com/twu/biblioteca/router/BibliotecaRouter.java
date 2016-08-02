package com.twu.biblioteca.router;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.handler.*;

public class BibliotecaRouter {
    private RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerContext = new RouterContext(routerState);
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage(String userInput) throws Exception {
        return getActionHandler().handle(userInput);
    }

    private IActionHandler getActionHandler() throws Exception {
        switch (routerContext.getCurrentState()) {
            case Initialize:
                return new InitialHandler(routerContext);
            case MainMenu:
                return new MainMenuHandler(routerContext, bibliotecaService);
            case CheckBook:
                return new CheckBookHandler(routerContext, bibliotecaService);
            case ReturnBook:
                return new ReturnBookHandler(routerContext, bibliotecaService);
            case CheckMovie:
                return new CheckMovieHandler(routerContext, bibliotecaService);
            case Login:
                return new LoginHandler(routerContext, bibliotecaService);
        }

        throw new Exception("Invalid router state!");
    }
}

