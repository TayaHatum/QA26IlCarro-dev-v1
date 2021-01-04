package com.telranqa26.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationTest() throws InterruptedException {

        app.getUserHelper().openRegForm();
        String email =  "my." + System.currentTimeMillis() + "@gmail.com";
        System.out.println(email);
        app.getUserHelper().fillRegForm("Lola", "Lol", email, "Lol12345");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(3000);
        app.getUserHelper().clickYallaButton();
        app.getUserHelper().pause(2000);
        Assert.assertFalse(app.getUserHelper().isRegistrationFormPresent());

    }
    @Test
    public void registrationTest2() throws InterruptedException {

        app.getUserHelper().openRegForm();
        String email =  "don.email" + System.currentTimeMillis() + "@gmail.com";
        app.getUserHelper().fillRegForm("Dina", "Don", "email", "TestDon12345");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(3000);
        app.getUserHelper().clickYallaButton();
        app.getUserHelper().pause(2000);
        Assert.assertFalse(app.getUserHelper().isRegistrationFormPresent());

    }
    @Test
    public void registrationTestNegative() throws InterruptedException {

        app.getUserHelper().openRegForm();
        String email =  "mon.email" + System.currentTimeMillis() + "@gmail.com";
        app.getUserHelper().fillRegForm("Mona", "Mon", email, "Mona1");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(3000);
        app.getUserHelper().clickYallaButton();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationFormPresent());

    }

}
