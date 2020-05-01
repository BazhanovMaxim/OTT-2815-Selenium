package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObject.BasePage;
import webDriver.ManageDriver;

public class Hooks{
    @Before
    public static void setUp(){
        BasePage basePage = new BasePage();
        basePage.openUrl();
    }

    @After
    public static  void tearDown(){
        ManageDriver manageDriver = new ManageDriver();
        manageDriver.quitDriver();
    }
}
