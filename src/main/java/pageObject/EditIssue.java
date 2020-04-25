package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Edit Issue")
public class EditIssue extends TestBase{

    @ElementTitle(ElementTitle = "Edit Issue")
    @FindBy(css = ".jira-dialog-heading > h2")
    private WebElement editIssueTitle;

    @ElementTitle(ElementTitle = "Summary")
    @FindBy(id = "summary")
    private WebElement summaryField;

    @ElementTitle(ElementTitle = "Priority")
    @FindBy(id = "priority-field")
    private WebElement issuePrioritySpan;

    @ElementTitle(ElementTitle = "High")
    @FindBy(className = "aui-list-item-li-high")
    private WebElement issuePriorityHigh;

    @ElementTitle(ElementTitle = "Update")
    @FindBy(id = "edit-issue-submit")
    private WebElement issueUpdateButton;
}
