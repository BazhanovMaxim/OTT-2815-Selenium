package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "Навигационная панель")
public class NavigationPanel extends BasePage {

    @ElementTitle(ElementTitle = "Issue")
    @FindBy(id = "find_link")
    private WebElement Issue;

    @ElementTitle(ElementTitle = "Reported By Me")
    @FindBy(id = "filter_lnk_reported_lnk")
    private WebElement reporterByMeLink;

    @ElementTitle(ElementTitle = "Create")
    @FindBy(id = "create_link")
    private WebElement createButton;

    @ElementTitle(ElementTitle = "User profile")
    @FindBy(css = "#header-details-user-fullname > span > span > img")
    private WebElement profileLink;

    @ElementTitle(ElementTitle = "LogOut")
    @FindBy(id = "log_out")
    private WebElement logOutButton;
}
