package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public final class ManageDriver {

    private static ManageDriver manageDriver;

    public WebDriver webDriver;
    private static Properties properties;

    public static ManageDriver getInstance() {
        if (manageDriver == null) {
            manageDriver = new ManageDriver();
        }
        return manageDriver;
    }

    private ManageDriver(){
        WebDriver createWebDriver;
        try{
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(
                    "src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String BROWSER_NAME = properties.getProperty("browser");
        final String PATH_TO_CHROME = properties.getProperty("path_to_chrome");
        final String PAGE_LOAD_TIMEOUT = properties.getProperty("page_load_timeout");
        final String IMPLICIT_WAIT = properties.getProperty("implicitWait");
        final String BASE_URL = properties.getProperty("base_url");

        System.setProperty(BROWSER_NAME, PATH_TO_CHROME);
        createWebDriver = new ChromeDriver();
        createWebDriver.manage().window().maximize();
        createWebDriver.manage().deleteAllCookies();
        createWebDriver.manage().timeouts().pageLoadTimeout(Long.parseLong(PAGE_LOAD_TIMEOUT), TimeUnit.SECONDS);
        createWebDriver.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        createWebDriver.get(BASE_URL);
        this.webDriver = createWebDriver;
    }
}
