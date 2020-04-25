package stepDefs;

import allure.AllureLogger;
import filesUtils.ReadFile;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pageObject.TestBase;
import restAPI.request.PostRequest;

public class CreateIssue extends AllureLogger {

    private ReadFile readFile;
    private PostRequest postRequest;
    private TestBase testBase;

    @Step("Отправляется запрос на создание записи")
    @Тогда("отправляется запрос на создание записи")
    public void sendRequestToCreateIssue() {
        readFile = new ReadFile();
        postRequest = new PostRequest();
        String userLogin = readFile.returnUserLogin();
        String userPassword = readFile.returnUserPassword();
        String pathToJsonFileForCreateWithAPI = "src/main/resources/response/createIssue.json";
        String pathToPostRequest = "/rest/api/2/issue/";
        Response response = postRequest.requestToPost(userLogin, userPassword, pathToJsonFileForCreateWithAPI, pathToPostRequest);
        equals("Проверка статуса кода", response.getStatusCode(), 201);
    }

    @Step("Пользователь в блоке Issue Type выбиарает {storyFieldSelect}")
    @И("пользователь в блоке Issue Type выбирает \"([^\"]*)\"$")
    public void пользовательВБлокеIssueTypeВыбирает(String storyFieldSelect) {
        testBase = new TestBase();
        testBase.clickToElement(storyFieldSelect);
        attachScreenshot();
    }
}
