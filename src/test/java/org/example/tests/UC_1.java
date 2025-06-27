package org.example.tests;

import org.apache.log4j.Logger;
import org.example.models.User;
import org.example.pages.Dashboard;
import org.example.pages.LoginPage;
import org.example.utils.LoggerUtil;
import org.junit.Test;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.containsString;


public class UC_1 extends Common{

    private static final Logger logger = LoggerUtil.getLogger(Dashboard.class);

    @Test
    public void loginWithoutUsernameAndPassword() {
        User user = new User("admin", "admin");

        logger.warn("Login without username and password");
        logger.info("User info: " + user);
        String errorMessage = new LoginPage(driver).
                openPage().
                inputUsername(user.getUsername()).
                inputPassword(user.getPassword()).
                clearUsername().
                clearPassword().
                submitFails().
                getErrorMessage();
        MatcherAssert.assertThat(errorMessage,containsString("Username is required"));
    }

}
