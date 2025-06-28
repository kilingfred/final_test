package org.example.tests;

import org.example.models.User;
import org.example.pages.LoginPage;
import org.example.utils.LoggerUtil;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.CoreMatchers.containsString;

public class UC_2 extends Common{

    private static final Logger logger = LoggerUtil.getLogger(UC_2.class);

    @Test
    public void loginWithoutPassword() {
        User user = new User("admin", "dummy");
        logger.warn("Login without password");
        logger.info("User info: {}", user);
        String errorMessage = new LoginPage(driver).
                openPage().
                inputUsername(user.getUsername()).
                inputPassword(user.getPassword()).
                clearPassword().
                submitFails().
                getErrorMessage();
        MatcherAssert.assertThat(errorMessage, containsString("Password is required"));
    }
}
