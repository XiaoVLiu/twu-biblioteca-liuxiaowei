package com.twu.biblioteca.router;

import com.twu.biblioteca.BibliotecaService;

public class BibliotecaRouter {
    private final RouterState routerState;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerState = routerState;
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage() {
        return new RouterMessage("Welcome to Biblioteca!");
    }
}
