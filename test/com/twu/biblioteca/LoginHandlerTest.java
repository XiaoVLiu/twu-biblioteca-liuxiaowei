package com.twu.biblioteca;

import com.twu.biblioteca.router.handler.LoginHandler;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LoginHandlerTest {
    @Test
    public void should_return_false_when_login_and_input_an_invalid_library_number() {
        assertFalse(LoginHandler.validateUser("invalid library number", ""));
    }

    @Test
    public void should_return_false_when_login_and_input_not_exist_library_number() {
        assertFalse(LoginHandler.validateUser("not-exist", ""));
    }

    @Test
    public void should_return_false_when_input_error_password() {
        assertFalse(LoginHandler.validateUser("001-0000", "error password"));
    }

    @Test
    public void should_return_true_when_input_correct_library_number_and_password() {
        assertTrue(LoginHandler.validateUser("001-0000", "password"));
    }
}
