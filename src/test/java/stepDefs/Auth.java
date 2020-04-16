package stepDefs;

import TestRefl.test_1;
import allure.AllureLogger;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.AuthPage;
import runner.Hooks;

@RunWith(Cucumber.class)
public class Auth extends Hooks {

    private AllureLogger allureLogger;
    private WebDriver webDriver = returnDriver();
    private AuthPage authPage;

    @Дано("открыть сайт Jira")
    public void открытьСайтJira() {
        allureLogger = new AllureLogger();
        authPage = new AuthPage(webDriver);
        authPage = PageFactory.initElements(webDriver, AuthPage.class);
        authPage.openSite();
        allureLogger.attachScreenshot();
    }

    @Когда("пользователь входит в систему")
    public void пользовательВходитВСистему(){
        allureLogger = new AllureLogger();
        authPage = new AuthPage(webDriver);
        authPage = PageFactory.initElements(webDriver, AuthPage.class);
        authPage.enterValue("BazhanovMaxim", "vUdd86z?VRId");
        allureLogger.attachScreenshot();
    }

    @Тогда("открывается страница \"([^\"]*)\"$")
    public void открываетсяСтраница(String arg0) throws InstantiationException, IllegalAccessException {
        test_1 test = new test_1();
        test.test();
        webDriver.quit();
    }
}
