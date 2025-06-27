package org.example.tests;

import org.apache.log4j.Logger;
import org.example.models.User;
import org.example.pages.Dashboard;
import org.example.pages.LoginPage;
import org.example.utils.LoggerUtil;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class UC_3 extends Common{

    private static final Logger logger = LoggerUtil.getLogger(Dashboard.class);

    @Test
    public void loginWithUsernameAndPassword() {
        User user = new User();
        logger.warn("Login with username and password");
        logger.info("User info: " + user);
        String title = new LoginPage(driver).
                openPage().
                inputUsername(user.getUsername()).
                inputPassword(user.getPassword()).
                submitSuccess().
                openPage().
                getTitle();
        MatcherAssert.assertThat(title, containsString("Swag Labs"));
    }
}
