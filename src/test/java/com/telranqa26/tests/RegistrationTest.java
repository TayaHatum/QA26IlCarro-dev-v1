package com.telranqa26.tests;

import com.telranqa26.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test
    public void registration()  {

        app.getUserHelper().openRegForm();
        String email = "mon.email" + System.currentTimeMillis()/1000%3600 + "@gmail.com";

        System.out.println("Registration eith email --> " +email);
        app.getUserHelper().fillRegForm(new User().withfName("Mona").withlName("Mon").
                withEmail(email).withPassword("TestMon12345"));
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().clickYallaButton();
        Assert.assertTrue(app.getUserHelper().isLoginTitlePresent());

    }

}
