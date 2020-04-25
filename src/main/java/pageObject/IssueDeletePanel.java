package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Delete Issue")
public class IssueDeletePanel extends TestBase {

    @ElementTitle(ElementTitle = "Delete Issue")
    @FindBy(css = ".jira-dialog-heading")
    private WebElement reportedByMeTitle;

    @ElementTitle(ElementTitle = "Delete")
    @FindBy(id = "delete-issue-submit")
    private WebElement deleteIssueButton;
}
