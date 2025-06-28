package org.example.tests;

import org.apache.logging.log4j.Logger;
import org.example.models.User;
import org.example.pages.LoginPage;
import org.example.utils.LoggerUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class UC_3 extends Common{

    private static final Logger logger = LoggerUtil.getLogger(UC_3.class);

    @Test
    public void loginWithUsernameAndPassword() {
        User user = new User();
        logger.warn("Login with username and password");
        logger.info("User info: {}", user);
        String title = new LoginPage(driver).
                openPage().
                inputUsername(user.getUsername()).
                inputPassword(user.getPassword()).
                submitSuccess().
                openPage().
                getTitle();
        assertThat(title, containsString("Products"));
    }
}
