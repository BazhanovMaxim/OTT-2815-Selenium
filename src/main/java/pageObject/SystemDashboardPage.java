package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageEntry(PageTitle = "System Dashboard")
public class SystemDashboardPage extends BasePage {

    @ElementTitle(ElementTitle = "System Dashboard")
    @FindBy(css = ".aui-page-header-main > h1")
    private WebElement titleSystemDashboard;

}
