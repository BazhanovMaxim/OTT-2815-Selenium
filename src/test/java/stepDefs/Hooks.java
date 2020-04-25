package stepDefs;

import io.cucumber.java.Before;
import pageObject.TestBase;

public class Hooks{
    @Before
    public static void setUp(){
        TestBase testBase = new TestBase();
        testBase.openUrl();
    }
}
