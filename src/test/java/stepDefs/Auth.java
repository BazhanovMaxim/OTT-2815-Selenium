package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObject.ManageDriver;
import pageObject.TestBase;
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

    private TestBase testBase;

    @Step("Открывается страница {namePage}")
    @Тогда("открывается страница \"([^\"]*)\"$")
    public void pageOpens(String namePage){
        testBase = new TestBase();
        testBase.setPage(namePage);
        equals("Проверка заголовка страницы", testBase.getTitle(namePage), namePage);
        attachScreenshot();
    }

    @Step("Пользователь вводит свои данные")
    @Когда("пользователь вводит свои данные")
    public void userEntersInTheField(DataTable dataTable){
        testBase = new TestBase();
        Map<String, String> getMapDataUser = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : getMapDataUser.entrySet()){
            testBase.EnterValueToFill(entry.getKey(), entry.getValue());
        }
        attachScreenshot();
    }

    @Step("Пользователь нажимает на кнопку {nameButton}")
    @И("пользователь нажимает на кнопку \"([^\"]*)\"$")
    public void userClickToButton(String nameButton){
        testBase = new TestBase();
        testBase.clickToElement(nameButton);
        attachScreenshot();
    }

    @Step("Закрывается браузер")
    @И("закрывается браузер")
    public void browserClose() {
        testBase = new TestBase();
        //testBase.closeDriver();
    }
}
