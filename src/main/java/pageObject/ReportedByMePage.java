package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Reported by me")
public class ReportedByMePage extends TestBase {

    @ElementTitle(ElementTitle = "MAX-2")
    @FindBy(xpath = "/html/body/div[1]/section/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[1]")
    private WebElement IssueMAX2;

    @ElementTitle(ElementTitle = "Reported by me")
    @FindBy(className = ".search-title")
    private WebElement reportedByMeTitle;

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
    @FindBy(id = "edit-issue > .trigger-label")
    private WebElement issueEditButton;

    @ElementTitle(ElementTitle = "Key")
    @FindBy(id = "key-val")
    private WebElement reporterByMeLink;

    @ElementTitle(ElementTitle = "Create")
    @FindBy(id = "create_link")
    private WebElement createButton;
}
