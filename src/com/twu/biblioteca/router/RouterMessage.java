package com.twu.biblioteca.router;

public class RouterMessage {
    public String text;
    public boolean isExit;
    public boolean waitForInput;

    public RouterMessage(String text, boolean waitForInput, boolean isExit) {
        this.text = text;
        this.waitForInput = waitForInput;
        this.isExit = isExit;
    }

    public String getText() {
        return text;
    }

    public boolean getWaitForUserInput() {
        return waitForInput;
    }
}
