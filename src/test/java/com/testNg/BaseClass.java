package com.testNg;

import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.slf4j.*;

public class BaseClass {
    protected WebDriver driver = null;
    protected WebDriver firefox_driver = null;
    protected WebDriver Firefox_driver = null;
    protected WebDriverWait wait = null;
    protected Logger logger;

    @BeforeSuite
    public void beforeValidationCheck()
    {
        try {
            Thread.sleep(500);
            //logger.debug("Test in rest");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Before any test validation");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Vignesh\\geckodriver-v0.32.0-win32(1)\\geckodriver.exe");
        Firefox_driver = new FirefoxDriver();
        Assert.assertNotNull(driver);
        //Assert.assertNotNull(Firefox_driver);
    }

    @AfterSuite
    public void closeDriver()
    {

        driver.quit();

        System.out.println("Driver has quitted");
    }
}
