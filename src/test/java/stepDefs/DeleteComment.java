package stepDefs;

import allure.AllureLogger;
import filesUtils.ReadFile;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pageObject.BasePage;
import restAPI.request.DeleteRequest;

public class DeleteComment extends AllureLogger {
    
    private DeleteRequest deleteRequest;
    private ReadFile readFile;
    private BasePage basePage;
    
    @Step("Отправляется запрос на удаление записи через API")
    @Тогда("Удаляется комментарий через API")
    public void deletedComments() {
        deleteRequest = new DeleteRequest();
        readFile = new ReadFile();
        String userLogin = readFile.returnUserLogin();
        String userPassword = readFile.returnUserPassword();
        String idComment = readFile.returnIdComment();
        String pathToDeleteRequest = "rest/api/2/issue/{IssueKey}/comment/" + idComment;
        String pathIssueKeyAPI = readFile.readFile("src/main/resources/response/keyIssueAPI.txt");
        Response response = deleteRequest.deleteRequest(pathIssueKeyAPI, userLogin, userPassword, pathToDeleteRequest);
        equals("Проверка статуса кода", response.getStatusCode(), 204);
    }

    @И("пользователь при помощи JS нажимает на элемент")
    public void userWithJSDeleteComment() {
        basePage = new BasePage();
        basePage.JSExecute();
    }
}
