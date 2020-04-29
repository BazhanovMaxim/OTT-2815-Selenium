package stepDefs;

import allure.AllureLogger;
import filesUtils.ReadFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Assert;
import pageObject.BasePage;
import restAPI.response.GetRequest;

import java.util.List;

public class GetIssueInfo extends AllureLogger {

    private GetRequest getIssueAPI;
    private ReadFile readFile;
    private BasePage basePage;

    @Step("Отправляется запрос на полечение информации о записи")
    @Тогда("отправляется запрос на получение информации о записи")
    public void postRequestToGetInfoAboutIssue() {
        getIssueAPI = new GetRequest();
        readFile = new ReadFile();
        String userLogin = readFile.returnUserLogin();
        String userPassword = readFile.returnUserPassword();
        String issueKey = readFile.readFile("src/main/resources/response/keyIssueAPI.txt");
        String pathToPostRequest = "http://localhost:8080/rest/api/2/issue/{key_value_issue}";
        Response response  = getIssueAPI.getRequest(issueKey, userLogin, userPassword, pathToPostRequest);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Step("Пользователь записывает информацию о записи в файл 'InfoAboutIssueUI.txt'")
    @И("пользователь записывает информацию о записи в \"([^\"]*)\"$")
    public void userWritesWithInformationAboutTheEntryIn(String nameFile, DataTable dataTable) {
        basePage = new BasePage();
        List<?> getMapDataUser = dataTable.asList();
        basePage.getInfoIssue(nameFile, getMapDataUser);
        getBytesAnnotationWithArgs(nameFile);
    }
}
