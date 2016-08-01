package com.twu.biblioteca.router;

public class RouterMessage {
    private String text;
    private boolean isExit;
    private boolean waitForInput;

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

    public boolean getIsExit() {
        return isExit;
    }
}
