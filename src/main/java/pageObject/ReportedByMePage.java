package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Reported by me")
public class ReportedByMePage extends TestBase {

    @ElementTitle(ElementTitle = "Reported by me")
    @FindBy(css = ".search-title")
    private WebElement reportedByMeTitle;

    @ElementTitle(ElementTitle = "More")
    @FindBy(css = "#opsbar-operations_more > .dropdown-text")
    private WebElement issueMoreButton;

    @ElementTitle(ElementTitle = "Delete")
    @FindBy(css = "#delete-issue > a")
    private WebElement issueDeleteButton;

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
    @FindBy(id = "key-val")
    private WebElement reporterByMeLink;

    @ElementTitle(ElementTitle = "Create")
    @FindBy(id = "create_link")
    private WebElement createButton;
}
