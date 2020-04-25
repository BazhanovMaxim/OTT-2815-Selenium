package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Create Issue")
public class CreateIssue extends TestBase{

    @ElementTitle(ElementTitle = "Create Issue")
    @FindBy(css = ".jira-dialog-heading > h2")
    private WebElement createIssueTitle;

    @ElementTitle(ElementTitle = "MAXOAT (MAX)")
    @FindBy(className = "aui-list-item-link")
    private WebElement maxOAT;

    @ElementTitle(ElementTitle = "Story")
    @FindBy(className = "aui-iconised-link")
    private WebElement storyFieldSelect;

    @ElementTitle(ElementTitle = "Project")
    @FindBy(id = "project-field")
    private WebElement issueProjectField;

    @ElementTitle(ElementTitle = "Issue Type")
    @FindBy(id = "issuetype-field")
    private WebElement issueTypeField;

    @ElementTitle(ElementTitle = "Summary")
    @FindBy(id = "summary")
    private WebElement issueSummaryField;

    @ElementTitle(ElementTitle = "Assiqn to me")
    @FindBy(id = "assign-to-me-trigger")
    private WebElement assiqnToMeLink;

    @ElementTitle(ElementTitle = "Create")
    @FindBy(css = "#create-issue-submit")
    private WebElement createButton;

    @ElementTitle(ElementTitle = "Panel was created")
    @FindBy(css = ".issue-created-key")
    private WebElement issueAddedPanel;
}
