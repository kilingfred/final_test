package org.example.tests;

import org.example.driver.DriverSimpleton;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Common {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverSimpleton.getDriver();
    }

    @After
    public void tearDown() {
        DriverSimpleton.quitDriver();
    }
}
