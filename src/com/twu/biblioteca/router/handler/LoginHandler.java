package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.Service.BibliotecaService;
import com.twu.biblioteca.fixtures.UserFixture;
import com.twu.biblioteca.model.UserInfo;
import com.twu.biblioteca.router.RouterContext;
import com.twu.biblioteca.router.RouterMessage;
import com.twu.biblioteca.router.RouterState;

import java.util.HashMap;
import java.util.regex.Pattern;

public class LoginHandler implements IActionHandler{

    static final String libraryNumberRegex = ".*-.*";
    private final RouterContext routerContext;
    private final BibliotecaService bibliotecaService;

    public LoginHandler(RouterContext routerContext, BibliotecaService bibliotecaService) {
        this.routerContext = routerContext;
        this.bibliotecaService = bibliotecaService;
    }

    public static boolean validateUser(String libraryNumber, String password) {
        if (!Pattern.matches(libraryNumberRegex, libraryNumber)) {
            return false;
        }

        HashMap<String, UserInfo> users = UserFixture.loadAllUsers();
        if (users.containsKey(libraryNumber) && users.get(libraryNumber).getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    @Override
    public RouterMessage handle(String userInput) {
        routerContext.setNextState(RouterState.MainMenu);
        String[] split = userInput.split(" ");

        if (split.length != 2) {
            return new RouterMessage("", false, false);
        }

        validateUser(split[0], split[1]);
        return new RouterMessage("", false, false);
    }
}
