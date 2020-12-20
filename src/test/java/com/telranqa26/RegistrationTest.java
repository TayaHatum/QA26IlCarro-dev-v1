package com.telranqa26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd=new ChromeDriver();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");

    }

    @Test
    public void registrationTest() throws InterruptedException {
        //open reg form
        wd.findElement(By.cssSelector("[href='/signup']")).click();
        Thread.sleep(3000);
        //fill name
        WebElement firstNameInput = wd.findElement(By.cssSelector("#first_name"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("Taya");
        //fill last name
        WebElement secondNameInput = wd.findElement(By.cssSelector("#second_name"));
        secondNameInput.click();
        secondNameInput.clear();
        secondNameInput.sendKeys("Hatum");
        //fill email
        WebElement emailInput = wd.findElement(By.cssSelector("#email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("hatum.testing@gmail.com");
        //fill password
        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("21TayaHatum21");
        // click check_policy
        wd.findElement(By.cssSelector("#check_policy")).click();
        // click yalla
        //
        // wd.findElement(By.cssSelector(".yalla_yalla__1Jxk6")).click();
       // wd.findElement(By.className("yalla_yalla__1Jxk6")).click();
        wd.findElement(By.ByClassName.className("yalla_yalla__1Jxk6"));
        Thread.sleep(2000);


    }

    @AfterMethod
    public void tiarDown(){
        wd.quit();

    }
}
