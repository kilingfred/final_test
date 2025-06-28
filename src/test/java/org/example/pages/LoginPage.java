package org.example.pages;

import org.apache.logging.log4j.Logger;
import org.example.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v135.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.example.driver.DriverSimpleton.driver;

public class LoginPage extends Page {
    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitInput;

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private static final Logger logger = LoggerUtil.getLogger(LoginPage.class);

    public WebElement errorMessage;

    private final String BASE_URL = "https://www.saucedemo.com";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LoginPage inputUsername(String username) {
        logger.info("Inputting username: {}", username);
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        logger.info("Inputting password: {}", password);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage submitFails() {
        logger.info("Submitting fails");
        submitInput.click();
        return this;
    }

    public Dashboard submitSuccess() {
        logger.info("Submitting success");
        submitInput.click();
        return new Dashboard();
    }

    public LoginPage openPage()
    {
        logger.info("Opening login page");
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getErrorMessage() {
        errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']")));
        return errorMessage.getText();
    }

    public LoginPage clearInput(WebElement input) {
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public LoginPage clearUsername() {
        logger.info("Clearing username");
        return clearInput(usernameInput);
    }

    public LoginPage clearPassword() {
        logger.info("Clearing password");
        return clearInput(passwordInput);
    }
}
