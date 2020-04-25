package stepDefs;

import allure.AllureLogger;
import filesUtils.ReadFile;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pageObject.TestBase;
import restAPI.request.DeleteRequest;

public class DeleteIssue extends AllureLogger {

    private DeleteRequest deleteIssueAPI;
    private ReadFile readFile;
    private TestBase testBase;

    @Step("Отправляется запрос на удаление записи")
    @Тогда("отправляется запрос на удаление записи")
    public void requestToDeleteIssue() {
        deleteIssueAPI = new DeleteRequest();
        readFile = new ReadFile();
        String userLogin = readFile.returnUserLogin();
        String userPassword = readFile.returnUserPassword();
        String pathToDeleteRequest = "/rest/api/2/issue/{issueIdOrKey}";
        String pathIssueKeyAPI = readFile.readFile("target\\TestsFiles\\IssueKeyAPI.txt");
        Response response = deleteIssueAPI.deleteRequest(pathIssueKeyAPI, userLogin, userPassword, pathToDeleteRequest);
        equals("Проверка статуса кода", response.getStatusCode(), 204);
    }

    @Step("Пользовать выбирает запись по Summary {summaryName}")
    @Когда("пользователь выбирает запись по Summary \"([^\"]*)\"$")
    public void UserSelectsAnEntryBySummary(String summaryName) {
        testBase = new TestBase();
        testBase.clickToIssueByKeyOrSummary(summaryName);
        attachScreenshot();
    }
}
