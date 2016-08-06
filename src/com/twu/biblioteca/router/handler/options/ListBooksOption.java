package com.twu.biblioteca.router.handler.options;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.model.ModelExtension;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;

public class ListBooksOption implements IOptionHandlers{
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public ListBooksOption(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public RouterMessage handle(String userInput) {
        return new RouterMessage(ModelExtension.toFormattedString(bibliotecaService.listAllBooks()), false, false);
    }
}
