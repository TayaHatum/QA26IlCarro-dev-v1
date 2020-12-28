package com.telranqa26;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationTest() throws InterruptedException {

        openRegForm();
        String email =  "my." + System.currentTimeMillis() + "@gmail.com";
        System.out.println(email);
        fillRegForm("Lola", "Lol", email, "Lol12345");
        selectCheckBox();
        pause(3000);
        clickYallaButton();
        pause(2000);
        Assert.assertFalse(isRegistrationFormPresent());

    }
    @Test
    public void registrationTest2() throws InterruptedException {

        openRegForm();
        String email =  "don.email" + System.currentTimeMillis() + "@gmail.com";
        fillRegForm("Dina", "Don", "email", "TestDon12345");
        selectCheckBox();
        pause(3000);
        clickYallaButton();
        pause(2000);
        Assert.assertFalse(isRegistrationFormPresent());

    }
    @Test
    public void registrationTestNegative() throws InterruptedException {

        openRegForm();
        String email =  "mon.email" + System.currentTimeMillis() + "@gmail.com";
        fillRegForm("Mona", "Mon", email, "Mona1");
        selectCheckBox();
        pause(3000);
        clickYallaButton();
        pause(2000);
        Assert.assertTrue(isRegistrationFormPresent());

    }

}
