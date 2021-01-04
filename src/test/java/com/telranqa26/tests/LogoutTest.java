package com.telranqa26.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{
    public LogoutTest() {
        System.out.println("Im  test logout");
    }

    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.getUserHelper().isUserLoggedIn()){
            app.getUserHelper().login();

        }

    }

    @Test
    public void logOutTest() throws InterruptedException {


        app.getUserHelper().clickLogOutButton();
        Assert.assertFalse(app.getUserHelper().isUserLoggedIn());
        System.out.println("Im  test ");

    }

}
