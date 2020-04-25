package stepDefs;

import io.qameta.allure.Step;
import pageObject.TestBase;
import allure.AllureLogger;
import filesUtils.CreateFile;
import filesUtils.ReadFile;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import restAPI.request.PostRequest;

public class AddComment extends AllureLogger {

    private PostRequest postRequest;
    private String comment;
    private ReadFile readFile;
    private CreateFile createFile;
    private TestBase testBase;

    @Step("Отправляется запрос на добавления комментария")
    @Тогда("отправляется запрос на добавления комментария")
    public void requestIsSentToAddAComment() {
        postRequest = new PostRequest();
        readFile = new ReadFile();
        // Отправка запроса
        String userLogin = readFile.returnUserLogin();
        String userPassword = readFile.returnUserPassword();
        String issueKey = readFile.readFile("src/main/resources/response/keyIssueAPI.txt");
        String pathToJsonFileForCreateWithAPI = "src/main/resources/response/addComment.json";
        String pathToPostRequest = "/rest/api/2/issue/" + issueKey + "/comment";
        Response response = postRequest.requestToPost(userLogin, userPassword, pathToJsonFileForCreateWithAPI, pathToPostRequest);
        equals("Проверка статуса кода", response.getStatusCode(), 201);
    }

    @Step("Пользователь нажимает на {namePage} на кнопку {nameButton}")
    @Тогда("пользователь нажимает на \"([^\"]*)\" на кнопку \"([^\"]*)\"$")
    public void userClicksOnThePageNameOnTheButton(String namePage, String nameButton) {
        createFile = new CreateFile();
        testBase = new TestBase();
        testBase.setPage(namePage);
        testBase.clickToElement(nameButton);
        attachScreenshot();
    }

    @Step("Пользователь выбирает запись по ключу {issueKey}")
    @Когда("пользователь выбирает запись по ключу \"([^\"]*)\"$")
    public void UserSelectsAnEntryByKey(String issueKey) {
        testBase = new TestBase();
        testBase.clickToIssueByKeyOrSummary(issueKey);
    }

    @Step("Пользователь в поле {nameField} печатает {commentText}")
    @Тогда("пользователь в поле \"([^\"]*)\" печатает \"([^\"]*)\"$")
    public void userInThePrintField(String nameField, String commentText) {
        testBase = new TestBase();
        testBase.EnterValueToFill(nameField, commentText);
    }
}
