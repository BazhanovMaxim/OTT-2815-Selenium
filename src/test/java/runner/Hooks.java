package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks{

    WebDriver webDriver;

    public WebDriver returnDriver(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
