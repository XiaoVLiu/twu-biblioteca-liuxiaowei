package com.twu.biblioteca.router;

public class RouterContext {
    private RouterState currentState;

    public RouterContext(RouterState routerState) {
        this.currentState = routerState;
    }

    public RouterState getCurrentState() {
        return currentState;
    }

    public void setNextState(RouterState routerState) {
        this.currentState = routerState;
    }
}
