package com.telranqa26;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!isUserLoggedIn()){
            login();
        }

    }

    @Test
    public void logOutTest() throws InterruptedException {

        clickLogOutButton();
        Assert.assertFalse(isUserLoggedIn());

    }

}
