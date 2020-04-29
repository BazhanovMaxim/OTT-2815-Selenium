package stepDefs;

import io.qameta.allure.Step;
import pageObject.BasePage;
import allure.AllureLogger;
import filesUtils.CreateFile;
import filesUtils.ReadFile;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import restAPI.request.PostRequest;

public class AddComment extends AllureLogger {

    private PostRequest postRequest;
    private ReadFile readFile;
    private CreateFile createFile;
    private BasePage basePage;

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
        equals("Отправляется запрос на добавления комментария и проверяется статус код", response.getStatusCode(), 201);
    }

    @Step("Пользователь нажимает на {namePage} на кнопку {nameButton}")
    @Тогда("пользователь нажимает на \"([^\"]*)\" на кнопку \"([^\"]*)\"$")
    public void userClicksOnThePageNameOnTheButton(String namePage, String nameButton) {
        createFile = new CreateFile();
        basePage = new BasePage();
        basePage.setPage(namePage);
        basePage.clickToElement(nameButton);
        attachScreenshot();
    }

    @Step("Пользователь выбирает запись по ключу {issueKey}")
    @Когда("пользователь выбирает запись по ключу \"([^\"]*)\"$")
    public void UserSelectsAnEntryByKey(String issueKey) {
        basePage = new BasePage();
        basePage.clickToIssueByKeyOrSummary(issueKey);
        attachScreenshot();
    }

    @Step("Пользователь в поле {nameField} печатает {commentText}")
    @Тогда("пользователь в поле \"([^\"]*)\" печатает \"([^\"]*)\"$")
    public void userInThePrintField(String nameField, String commentText) {
        basePage = new BasePage();
        basePage.EnterValueToField(nameField, commentText);
        attachScreenshot();
    }
}
