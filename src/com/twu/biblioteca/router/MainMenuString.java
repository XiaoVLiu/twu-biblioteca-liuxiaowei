package com.twu.biblioteca.router;

public class MainMenuString {

    private static final String MAIN_MENU_HEADER = "************Main Menu************\n";
    private static final String MAIN_MENU_NECESSARY = "1. List Books\n" +
            "2. Checkout Book\n" +
            "3. Return Book\n" +
            "4. List Movies\n" +
            "5. Checkout Movie\n" +
            "6. Login\n";
    private static final String MAIN_MENU_FOOTER = "q. Quit\n" +
            "*********************************\n";
    private static final String MAIN_MENU_OPTIONAL = "7. User Information\n";

    public static String getString() {
        return MAIN_MENU_HEADER + MAIN_MENU_NECESSARY + MAIN_MENU_FOOTER;
    }

    public static String getStringWithUserInfo() {
        return MAIN_MENU_HEADER + MAIN_MENU_NECESSARY + MAIN_MENU_OPTIONAL + MAIN_MENU_FOOTER;
    }
}
