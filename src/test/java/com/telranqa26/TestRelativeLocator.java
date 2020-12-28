package com.telranqa26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRelativeLocator {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
    }


    @Test
    public void testRegistration() throws InterruptedException {
        //open reg form
        wd.findElement(By.cssSelector("[href='/signup']")).click();

        //fill reg form
        wd.findElement(By.cssSelector("#first_name")).click();
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("Yulia");

        /*wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("Rosenblum");*/



        /*String email = "my.email"+System.currentTimeMillis()+"@gmail.com";
        System.out.println("email is:" + email);
        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys(email);*/

        WebElement lName=wd.findElement(By.id("second_name"));
        lName.clear();
        lName.sendKeys("LastName");

        WebElement email=wd.findElement(RelativeLocator.withTagName("input").below(lName));
        email.click();
        email.sendKeys("21tyyt6@mail.com");

        WebElement password =wd.findElement(By.cssSelector("#password"));
        password.click();
        password.clear();
        password.sendKeys("Ro1234555");

        //selectCheckBox
        WebElement cheerBox = wd.findElement(By.cssSelector("#check_policy"));
        cheerBox.click();
        Thread.sleep(2000);

        WebElement policy =wd.findElement(RelativeLocator.withTagName("span").toRightOf(cheerBox).below(password));

        System.out.println(policy.getText());

        //clickYullaBut
        wd.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(3000);

        Assert.assertFalse(wd.findElements(By.xpath("//h2[contains(.,'Registration')]")).size()>0);
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();

    }


}
