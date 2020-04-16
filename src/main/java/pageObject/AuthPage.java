package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Страница авториации")
public class AuthPage {

    //@ElementTitle(ElementTitle = "Запуск теста")
    public String testVoid(){
        return "Hello world";
    }

    /**
     * Пустой конструктор нужен, чтобы в рефлексии использовать newInstance()
     */
    public AuthPage(){

    }

    private WebDriver driver;

    public AuthPage(WebDriver driverPage){
        this.driver = driverPage;
    }

    @ElementTitle(ElementTitle = "Логин")
    @FindBy(id = "login_field")
    private WebElement loginField;

    @ElementTitle(ElementTitle = "Пароль")
    @FindBy(id = "password")
    private WebElement passwordField;

    @ElementTitle(ElementTitle = "Войти")
    @FindBy(className = "btn")
    private WebElement btnEnter;

    public void openSite(){
        driver.get("https://github.com/login");
    }

    public void enterValue(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        btnEnter.click();
    }
}
