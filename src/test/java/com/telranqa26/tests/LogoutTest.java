package com.telranqa26.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition()  {
        if(!app.getUserHelper().isUserLoggedIn()){
            app.getUserHelper().login();

        }

    }

    @Test
    public void logOutTest()  {


        app.getUserHelper().clickLogOutButton();
        Assert.assertFalse(app.getUserHelper().isUserLoggedIn());
        System.out.println("Im  test ");

    }

}
