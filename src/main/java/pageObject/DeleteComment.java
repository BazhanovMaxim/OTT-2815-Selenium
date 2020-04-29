package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Delete Comment")
public class DeleteComment extends BasePage {

    @ElementTitle(ElementTitle = "Delete Comment")
    @FindBy(css = ".jira-dialog-heading > h2")
    private WebElement deleteCommentTitle;

    @ElementTitle(ElementTitle = "Delete")
    @FindBy(id = "comment-delete-submit")
    private WebElement deleteButton;

}
