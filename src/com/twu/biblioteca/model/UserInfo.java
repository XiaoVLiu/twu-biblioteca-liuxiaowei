package com.twu.biblioteca.model;

public class UserInfo {

    private final String libraryNumber;
    private final String password;

    public UserInfo(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
