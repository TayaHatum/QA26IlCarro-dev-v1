package com.telranqa26.application;

import com.telranqa26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }



    public void login() {
        clickByCss("[href='/login']");
        fillLoginForm(new User().withEmail("my.1609162132228@gmail.com").withPassword( "Lol12345"));
        clickByCss("[type=submit");
    }

    public boolean isLoginTitlePresent() {
        return new WebDriverWait(wd, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h2[text()='Log in']"))) != null;
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

    public void fillRegForm(User user) {
        type(By.cssSelector("#first_name"), user.getfName());
        type(By.cssSelector("#second_name"), user.getlName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }



    public void fillLoginForm(User user) {
        typeByCss("[name='email']", user.getEmail());
        typeByCss("[name='password']", user.getPassword());
    }



    public void clickLogOutButton() {
        clickByxPath("//a[contains(.,'logOut')]");
    }

    public void clickLoginButton() {
        clickByCss("[href='/login']");
    }

}
