package com.twu.biblioteca.fixtures;

import com.twu.biblioteca.model.UserInfo;

import java.util.HashMap;

public class UserFixture {
    public static HashMap<String, UserInfo> loadAllUsers() {
        HashMap<String, UserInfo> userInfoMap = new HashMap<String, UserInfo>();
        userInfoMap.put("001-0000", new UserInfo("001-0000", "password"));
        userInfoMap.put("002-0000", new UserInfo("002-0000", "password"));

        return userInfoMap;
    }
}
