package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(PageTitle = "Reported By Me")
public class ReportedByMePage extends BasePage{

    public ReportedByMePage(){
        PageFactory.initElements(webDriver, this);
    }

    @ElementTitle(ElementTitle = "Edit")
    @FindBy(id = "edit-issue > .trigger-label")
    private WebElement issueEditButton;

    @ElementTitle(ElementTitle = "Key")
    @FindBy(id = "key-val")
    private WebElement reporterByMeLink;

    @ElementTitle(ElementTitle = "Create")
    @FindBy(id = "create_link")
    private WebElement createButton;

    @ElementTitle(ElementTitle = "User profile")
    @FindBy(id = "header-details-user-fullname > span > span > img")
    private WebElement profileLink;

    @ElementTitle(ElementTitle = "LogOut")
    @FindBy(id = "log_out")
    private WebElement logOutButton;

}
