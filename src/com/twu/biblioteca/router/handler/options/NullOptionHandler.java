package com.twu.biblioteca.router.handler.options;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.router.MainMenuString;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;

public class NullOptionHandler implements IOptionHandlers {
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public NullOptionHandler(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        String messageText = bibliotecaService.getCurrentUser() == null ?
                MainMenuString.getString() :
                MainMenuString.getStringWithUserInfo();

        return new RouterMessage(messageText, true, false);

    }
}
