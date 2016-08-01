package com.twu.biblioteca.router;

public class RouterMessage {
    public String text;
    public boolean isExit;

    public RouterMessage(String text, boolean isExit) {
        this.text = text;
        this.isExit = isExit;
    }
}
