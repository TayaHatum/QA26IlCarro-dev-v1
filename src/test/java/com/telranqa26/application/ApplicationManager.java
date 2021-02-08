package com.telranqa26.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    EventFiringWebDriver wd;
    Properties properties;
    UserHelper userHelper;
    CarHelper carHelper;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties= new Properties();
    }



    public void start() throws IOException {
        String target=System.getProperty("target","data");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        if(browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }else if(browser.equals(BrowserType.EDGE)){
        wd = new EventFiringWebDriver(new EdgeDriver());
    }

        wd.register(new ListenerNG());
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        carHelper=new CarHelper(wd);

    }

    public CarHelper getCarHelper() {
        return carHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public String setEmail(){
        return properties.getProperty("web.email");
    }
    public String setPassword(){
        return properties.getProperty("web.password");
    }
    public void stop() {
        wd.quit();
    }
}
