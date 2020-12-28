package com.telranqa26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd=new ChromeDriver();
        wd.navigate().to("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public void login() throws InterruptedException {
        clickByCss("[href='/login']");
        fillLoginForm("my.1609162132228@gmail.com", "Lol12345");
        pause(2000);
        clickByCss("[type=submit");
    }

    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(., 'Registration')]"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }
    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }
    public void clickLogoutButtonOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    protected void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    protected void fillRegForm(String fName, String lName, String email, String password) {
        type(By.cssSelector("#first_name"), fName);
        type(By.cssSelector("#second_name"), lName);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();

    }

    public void fillLoginForm(String email, String password) {
        typeByCss("[name='email']", email);
        typeByCss("[name='password']", password);
    }

    public void typeByCss(String cssSelector, String text) {
        clickByCss(cssSelector);
        wd.findElement(By.cssSelector(cssSelector)).clear();
        wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByxPath(String xPathSelector) {
        wd.findElement(By.xpath(xPathSelector)).click();
    }

    public void clickLogOutButton() {
        clickByxPath("//a[contains(.,'logOut')]");
    }


    public void clickLoginButton() {
        clickByCss("[href='/login']");
    }
}
