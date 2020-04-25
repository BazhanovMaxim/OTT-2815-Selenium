package stepDefs;

import allure.AllureLogger;
import filesUtils.ReadFile;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import restAPI.request.UpdateRequest;

public class UpdateIssue extends AllureLogger {

    private UpdateRequest updateIssueInfo;
    private ReadFile readFile;

    @Тогда("обновляется запись через API")
    public void обновляетсяЗаписьЧерезAPI() {
        updateIssueInfo = new UpdateRequest();
        readFile = new ReadFile();
        String userLogin = readFile.returnUserLogin();
        String userPassword = readFile.returnUserPassword();
        String pathToPutRequest = "/rest/api/2/issue/{key_issue}";
        String pathIssueKeyAPI = readFile.readFile("src/main/resources/response/keyIssueAPI.txt");
        Response response = updateIssueInfo.requestToUpdate(pathIssueKeyAPI, userLogin, userPassword, pathToPutRequest);
        equals("Проверка статуса кода", response.getStatusCode(), 204);
    }
}
