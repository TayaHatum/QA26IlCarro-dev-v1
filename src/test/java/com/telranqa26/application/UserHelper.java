package com.telranqa26.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
        System.out.println("Im helperUser");
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



    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void clickLogoutButtonOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }



    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }



    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void fillRegForm(String fName, String lName, String email, String password) {
        type(By.cssSelector("#first_name"), fName);
        type(By.cssSelector("#second_name"), lName);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }



    public void fillLoginForm(String email, String password) {
        typeByCss("[name='email']", email);
        typeByCss("[name='password']", password);
    }



    public void clickLogOutButton() {
        clickByxPath("//a[contains(.,'logOut')]");
    }

    public void clickLoginButton() {
        clickByCss("[href='/login']");
    }

}
