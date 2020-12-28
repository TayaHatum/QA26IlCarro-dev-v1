package com.telranqa26;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(isUserLoggedIn()){
            clickLogoutButtonOnHeader();
        }

    }


    @Test
    public void testLogin() throws InterruptedException {

        clickLoginButton();
        fillLoginForm("my.1609162132228@gmail.com", "Lol12345");
        pause(2000);
        clickYallaButton();

        Assert.assertTrue(isUserLoggedIn());


    }


}
