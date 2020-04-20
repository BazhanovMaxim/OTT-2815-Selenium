package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pageObject.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefs",
        plugin = {"pretty"}
)

public class TestRunner{

    @BeforeClass
    public static void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
    }
}