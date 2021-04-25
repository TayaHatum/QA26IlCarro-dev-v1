package com.telranqa26.tests;

import com.telranqa26.model.User;
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

    @Test(priority = 1)
    public void testLogin()  {

        app.getUserHelper().clickLoginButton();
        app.getUserHelper().fillLoginForm(new User()
                .withEmail(app.setEmail()).withPassword(app.setPassword()));

        app.getUserHelper().clickYallaButton();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

    }

}
