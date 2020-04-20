package stepDefs;

import pageObject.TestBase;
import allure.AllureLogger;
import filesUtils.CreateFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import java.util.Map;

@RunWith(Cucumber.class)
public class Auth extends AllureLogger {

    private CreateFile createFile;
    private TestBase testBase;

    @Дано("открыта \"([^\"]*)\"$")
    public void открытьСтраницуАвторизации(String namePage) {
        testBase = new TestBase();
        createFile = new CreateFile();
        System.out.println("Название авторизации: " + namePage);
        testBase.setPageTitle(namePage);
        System.out.println("Отправил название, получаю: " + testBase.getPageTitle());
        testBase.openURL();
        attachScreenshot();
    }

    @Когда("пользователь вводит свои данные")
    public void пользовательВПолеВводит(DataTable dataTable){
        testBase = new TestBase();
        Map<String, String> getMapDataUser = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : getMapDataUser.entrySet()){
            testBase.EnterValueToFill(entry.getKey(), entry.getValue());
        }
        attachScreenshot();
    }

    @И("пользователь нажимает на кнопку \"([^\"]*)\"$")
    public void пользователНажимаетНаКнопку(String nameButton){
        testBase = new TestBase();
        testBase.clickToElement(nameButton);
        attachScreenshot();
    }

    @Тогда("открывается страница \"([^\"]*)\"$")
    public void открываетсяСтраница(String namePage){
        attachScreenshot();
    }
}
