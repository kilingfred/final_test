package org.example.pages;

import org.apache.log4j.Logger;
import org.example.utils.LoggerUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v135.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.example.driver.DriverSimpleton.driver;

public class Dashboard extends Page {
    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement title;

    private static final Logger logger = LoggerUtil.getLogger(Dashboard.class);

    private final String DASHBOARD_URL = "https://www.saucedemo.com/inventory.html";

    public Dashboard() {
        PageFactory.initElements(driver, this);
    }

    public Dashboard openPage() {
        logger.trace("Entering openPage");
        driver.navigate().to(DASHBOARD_URL);
        return this;
    }

    public String getTitle() {
        return title.getText();
    }
}
