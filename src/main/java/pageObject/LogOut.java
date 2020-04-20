package pageObject;

import annotations.PageEntry;
import org.openqa.selenium.support.PageFactory;

@PageEntry(PageTitle = "Выход пользователя")
public class LogOut extends BasePage{

    public LogOut(){PageFactory.initElements(webDriver, this);}
}
