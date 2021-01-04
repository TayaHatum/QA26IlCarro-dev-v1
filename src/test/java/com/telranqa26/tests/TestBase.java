package com.telranqa26.tests;

import com.telranqa26.application.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public TestBase() {
        System.out.println("Im testbase constructor");
    }

    protected ApplicationManager app = new ApplicationManager();

    //@BeforeMethod
  @BeforeClass
    public void setUp(){
        app.start();


    }

    //@AfterMethod
    @AfterClass
    public void tearDown(){
        app.stop();


    }



}
