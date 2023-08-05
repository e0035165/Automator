package com.testNg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GfgSetup extends BaseClass {
    @BeforeTest
    public void preChecks()
    {
        Assert.assertNotNull(driver);
    }

    @Test(priority = 0)
    public void openGfg() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        //Assert.assertSame(driver.getCurrentUrl(),"https://www.google.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Geeksforgeeks");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Test(priority=1)
    public void clickonGfg() throws InterruptedException
    {
        //wait = new WebDriverWait(driver, 12);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[8]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"))).click();
        By locator = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3");
        driver.findElement(locator).click();

        driver.manage().window().maximize();
        Thread.sleep(4000);
    }
    @Test(priority = 2)
    public void clickSignin() throws InterruptedException
    {
        wait = new WebDriverWait(driver, 10);
        By locator = By.xpath("/html/body/div[1]/div[1]/ul[2]/li[3]/a");

        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            driver.findElement(locator).click();

        }catch(Exception E)
        {
            System.err.println(E.getMessage());
        }
        Thread.sleep(1400);
        By next = By.xpath("//*[@id=\"glogin\"]");
        driver.findElement(next).click();
        next = By.id("identifierId");
        driver.findElement(next).sendKeys("testuatvendet");
        driver.findElement(next).sendKeys(Keys.ENTER);
        wait = new WebDriverWait(driver, 10);
        next = By.name("password");

        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(next));
            driver.findElement(next).sendKeys("Common@2021");
            driver.findElement(next).sendKeys(Keys.ENTER);
        }catch(Exception E)
        {
            Assert.assertTrue(false);
            System.err.println(E.getMessage());
        }
    }

    @AfterTest
    public void Close()
    {
        driver.close();
        System.out.println("Driver has closed");
    }

}
