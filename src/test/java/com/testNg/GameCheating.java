package com.testNg;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class GameCheating extends BaseClass{
    @BeforeTest
    public void preCheck()
    {
        System.out.println("Before cheating, check the firefox driver");
        Assert.assertNotNull(firefox_driver);
    }


}
