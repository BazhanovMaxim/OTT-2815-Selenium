package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Welcome to Jira")
public class AuthPage extends TestBase {

    @ElementTitle(ElementTitle = "Welcome to Jira")
    @FindBy(css = ".aui-page-header-main > h1")
    private WebElement titleLogin;

    @ElementTitle(ElementTitle = "LoginField")
    @FindBy(id = "login-form-username")
    private WebElement LoginField;

    @ElementTitle(ElementTitle = "PasswordField")
    @FindBy(id = "login-form-password")
    private WebElement PasswordField;

    @ElementTitle(ElementTitle = "LogIn")
    @FindBy(id = "login-form-submit")
    private WebElement loginButton;
}
