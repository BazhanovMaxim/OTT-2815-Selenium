package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public final class ManageDriver {

    private static WebDriver webDriver;
    private static Properties properties;

    public static WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = ManageDriver();
        }
        return webDriver;
    }

    private static WebDriver ManageDriver(){
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
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(Long.parseLong(PAGE_LOAD_TIMEOUT), TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        //webDriver.get(BASE_URL);
        return webDriver;
    }
}
