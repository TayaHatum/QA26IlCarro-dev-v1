package com.telranqa26.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListenerNG extends AbstractWebDriverEventListener {

    public ListenerNG() {
        super();
    }

    Logger logger = LoggerFactory.getLogger(ListenerNG.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Start search --->" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(by + "<--- found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
       logger.error(throwable.toString());
        String pathToScreenshot = "src/test/screenshots/screen-"+ System.currentTimeMillis()+ ".png";
        HelperBase helperBase =new HelperBase(driver);
        helperBase.takeScreenshot(pathToScreenshot);
        logger.error(pathToScreenshot);
    }
}
