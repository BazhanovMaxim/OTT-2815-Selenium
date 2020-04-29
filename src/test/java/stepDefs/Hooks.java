package stepDefs;

import io.cucumber.java.Before;
import pageObject.BasePage;

public class Hooks{
    @Before
    public static void setUp(){
        BasePage basePage = new BasePage();
        basePage.openUrl();
    }
}
