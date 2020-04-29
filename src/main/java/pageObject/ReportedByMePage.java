package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Reported by me")
public class ReportedByMePage extends BasePage {

    @ElementTitle(ElementTitle = "Reported by me")
    @FindBy(css = ".search-title")
    private WebElement reportedByMeTitle;

    @ElementTitle(ElementTitle = "More")
    @FindBy(css = "#opsbar-operations_more > .dropdown-text")
    private WebElement issueMoreButton;

    @ElementTitle(ElementTitle = "Delete")
    @FindBy(css = "#delete-issue > a")
    private WebElement issueDeleteButton;

    @ElementTitle(ElementTitle = "Summary")
    @FindBy(css = "#summary-val")
    private WebElement issueSummary;

    @ElementTitle(ElementTitle = "Reporter")
    @FindBy(css = "#reporter-val span")
    private WebElement issueReporter;

    @ElementTitle(ElementTitle = "Type")
    @FindBy(css = "#type-val")
    private WebElement issueType;

    @ElementTitle(ElementTitle = "Priority")
    @FindBy(css = "#priority-val")
    private WebElement issuePriority;

    @ElementTitle(ElementTitle = "Resolution")
    @FindBy(css = "#resolution-val")
    private WebElement issueResolution;

    @ElementTitle(ElementTitle = "DataToCreated")
    @FindBy(css = "#created-val > .livestamp")
    private WebElement issueWasCreated;

    @ElementTitle(ElementTitle = "IssueWasUpdated")
    @FindBy(css = "#updated-val > .livestamp")
    private WebElement issueWasUpdate;

    @ElementTitle(ElementTitle = "Comment")
    @FindBy(css = "#comment-issue > .trigger-label")
    private WebElement issueCommentButton;

    @ElementTitle(ElementTitle = "Add")
    @FindBy(id = "issue-comment-add-submit")
    private WebElement issueCommentAddButton;

    @ElementTitle(ElementTitle = "Write comment")
    @FindBy(id = "comment")
    private WebElement issueCommentField;

    @ElementTitle(ElementTitle = "Edit")
    @FindBy(css = "#edit-issue > .trigger-label")
    private WebElement issueEditButton;

    @ElementTitle(ElementTitle = "Key")
    @FindBy(css = "#key-val")
    private WebElement reporterByMeLink;

    @ElementTitle(ElementTitle = "Create")
    @FindBy(id = "create_link")
    private WebElement createButton;
}
