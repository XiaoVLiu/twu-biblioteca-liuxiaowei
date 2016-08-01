package com.twu.biblioteca.router;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.tools.javac.file.Paths;
import com.twu.biblioteca.BibliotecaService;
import com.twu.biblioteca.source.MainMenuString;
import javafx.scene.shape.Path;

import java.io.File;
import java.nio.file.Files;

public class BibliotecaRouter {
    private final RouterState routerState;
    private final BibliotecaService bibliotecaService;

    public BibliotecaRouter(RouterState routerState, BibliotecaService bibliotecaService) {

        this.routerState = routerState;
        this.bibliotecaService = bibliotecaService;
    }

    public RouterMessage getRouterMessage() {
        if (routerState == RouterState.Initialize) {
            return new RouterMessage("Welcome to Biblioteca!");
        }

        return new RouterMessage(MainMenuString.getString());
    }
}
