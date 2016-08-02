package com.twu.biblioteca.router;

public class MainMenuString {

    private static final String mainMenuString =
            "************Main Menu************\n" +
                    "1. List Books\n" +
                    "2. Checkout Book\n" +
                    "3. Return Book\n" +
                    "4. List Movies" +
                    "q. Quit\n" +
                    "*********************************\n";

    public static String getString() {
        return mainMenuString;
    }
}
