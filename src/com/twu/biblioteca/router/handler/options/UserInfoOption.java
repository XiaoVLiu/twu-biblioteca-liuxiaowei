package com.twu.biblioteca.router.handler.options;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;

public class UserInfoOption implements IOptionHandlers{
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public UserInfoOption(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {

        if (bibliotecaService.getCurrentUser() == null) {
            return new RouterMessage("Not available option!", false, false);
        }

        return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.getCurrentUser()), false, false);
    }
}
