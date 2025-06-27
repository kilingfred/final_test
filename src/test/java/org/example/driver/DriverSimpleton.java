package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverSimpleton {
    public static WebDriver driver;
    private static final String browser = System.getProperty("browser", "chrome");

    private DriverSimpleton() {}

    public static WebDriver getDriver() {
       if (driver == null) {
           if (browser.equals("chrome")) {
               driver = new ChromeDriver();
           } else {
               driver = new EdgeDriver();
           }
           driver.manage().window().maximize();
       }
       return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
