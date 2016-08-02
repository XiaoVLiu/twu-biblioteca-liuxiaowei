package com.twu.biblioteca.router.handler;

import com.twu.biblioteca.fixtures.UserFixture;
import com.twu.biblioteca.model.UserInfo;

import java.util.HashMap;
import java.util.regex.Pattern;

public class LoginHandler {

    static final String libraryNumberRegex = ".*-.*";

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
}
