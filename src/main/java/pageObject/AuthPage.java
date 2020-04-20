package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(PageTitle = "Страница авторизации")
public class AuthPage extends BasePage{

    public AuthPage(){
        PageFactory.initElements(webDriver, this);
    }

    @ElementTitle(ElementTitle = "LoginField")
    @FindBy(id = "login-form-username")
    private WebElement LoginField;

    @ElementTitle(ElementTitle = "PasswordField")
    @FindBy(id = "login-form-password")
    private WebElement PasswordField;

    @ElementTitle(ElementTitle = "LogIn")
    @FindBy(id = "login")
    private WebElement LogIn;
}
