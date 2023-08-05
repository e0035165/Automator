package com.testNg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class BaseTest extends BaseClass {

    @BeforeTest
    public void preCheck()
    {

        logger = LoggerFactory.getLogger(BaseTest.class);
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);
    }
    @Test(priority = 1)
    public void firstTest() throws InterruptedException {
        try {
            logger.debug("Rest for 0.5 seconds in progressed");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        //goToHackerrank();
    }

    @Test(priority = 2)
    public void goToHackerrank() throws InterruptedException {
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Hackerrank");
        //Thread.sleep(100);
        logger.debug("Test going to rest for 4 seconds");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Hackerrank");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //Thread.sleep(400);

    }



    @Test(priority = 3)
    public void clickOnHackerrank() throws InterruptedException {
        //Thread.sleep(2000);
//        driver.navigate().to("https://www.google.com/");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Hackerrank");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        By locator = By.xpath("//*[text()='Login']");

        wait = new WebDriverWait(driver, 10);
        Assert.assertNotNull(wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement ele = driver.findElement(locator);
        ele.click();
    }

    @Test(priority = 4)
    public void Login() throws InterruptedException {
        logger.debug("Test going to rest for 0.5 seconds");
        Thread.sleep(500);
        driver.findElement(By.className("fl-button-text")).click();
        logger.debug("Test going to rest for 1 seconds");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div/div/div/div/form/button[2]/div/span")).click();
        logger.debug("Test going to rest for 0.5 seconds");
        Thread.sleep(500);
        Set<String> windownames = driver.getWindowHandles();
        By locater = By.id("identifierId");
        boolean accepted = false;
        for(String s: windownames)
        {
            driver.switchTo().window(s);
            //System.out.println(driver.getCurrentUrl());
            try{
                driver.findElement(locater);
                driver.findElement(locater).sendKeys("testuatvendet@gmail.com");
                driver.findElement(locater).sendKeys(Keys.ENTER);
                accepted = !accepted;
                //break;
                //driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("Common@2021");
                //driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys(Keys.ENTER);
            } catch(NoSuchElementException R)
            {
                System.err.println(R.getMessage());
            }
        }
        Assert.assertTrue(accepted);
    }

    @Test(priority=5)
    public void enterPassword()
    {

        Set<String>windownames = driver.getWindowHandles();
        By locater = By.name("password");
        boolean accepted = false;
        for(String s: windownames)
        {
            driver.switchTo().window(s);
            //System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getCurrentUrl());
            wait = new WebDriverWait(driver, 5);
            try
            {
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                WebElement ele = driver.findElement(locater);
                ele.sendKeys("Common@2021");
                ele.sendKeys(Keys.ENTER);
                accepted = true;

            } catch (Exception R)
            {
                System.err.println(R.getMessage());
            }

        }
        Assert.assertTrue(accepted);
    }

    @AfterTest
    public void postChecks()
    {
        driver.close();
    }




}
