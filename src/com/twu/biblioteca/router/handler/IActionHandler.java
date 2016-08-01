package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.router.RouterMessage;

public interface IActionHandler {
    RouterMessage handle(String userInput);
}
