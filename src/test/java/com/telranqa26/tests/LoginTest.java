package com.telranqa26.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @BeforeMethod

    public void ensurePrecondition() {

        if (app.getUserHelper().isUserLoggedIn()) {
            app.getUserHelper().clickLogoutButtonOnHeader();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {

        app.getUserHelper().clickLoginButton();
        app.getUserHelper().fillLoginForm("my.1609162132228@gmail.com", "Lol12345");
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButton();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

    }

}
