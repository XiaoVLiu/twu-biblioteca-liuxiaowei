package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

public class InitialHandler implements IActionHandler {
    private RouterContext routerContext;

    public InitialHandler(RouterContext routerContext) {
        this.routerContext = routerContext;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.MainMenu);
        return new RouterMessage("Welcome to Biblioteca!", false, false);
    }
}
