package stepDefs;

import io.qameta.allure.Step;
import pageObject.BasePage;
import allure.AllureLogger;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Cucumber.class)
public class Auth extends AllureLogger {

    private BasePage basePage;

    @Step("Открывается страница {namePage}")
    @Тогда("открывается страница \"([^\"]*)\"$")
    public void pageOpens(String namePage){
        basePage = new BasePage();
        basePage.setPage(namePage);
        equals("Проверка заголовка страницы", basePage.getTitle(namePage), namePage);
        attachScreenshot();
    }

    @Step("Пользователь вводит свои данные")
    @Когда("пользователь вводит свои данные")
    public void userEntersInTheField(DataTable dataTable){
        basePage = new BasePage();
        Map<String, String> getMapDataUser = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : getMapDataUser.entrySet()){
            basePage.EnterValueToField(entry.getKey(), entry.getValue());
        }
        attachScreenshot();
    }

    @Step("Пользователь нажимает на кнопку {nameButton}")
    @И("пользователь нажимает на кнопку \"([^\"]*)\"$")
    public void userClickToButton(String nameButton){
        basePage = new BasePage();
        basePage.clickToElement(nameButton);
        attachScreenshot();
    }
}
