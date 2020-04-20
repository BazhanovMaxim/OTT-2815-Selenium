package stepDefs;

import pageObject.TestBase;
import allure.AllureLogger;
import filesUtils.CreateFile;
import filesUtils.ReadFile;
import io.cucumber.java.ru.И;
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

    @Тогда("отправляется запрос на добавления комментария")
    public void отправляетсяЗапросНаДобавленияКомментария() {
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

    @Тогда("пользователь нажимает на \"([^\"]*)\" на кнопку \"([^\"]*)\"$")
    public void пользовательНажимаетНаНавигационнуюПанельНаКнопку(String namePage, String nameButton) {
        createFile = new CreateFile();
        testBase = new TestBase();
        System.out.println("Отправил название " + namePage);
        testBase.setPageTitle(namePage);
        System.out.println("Отправил название - получаю: " + testBase.getPageTitle());
        testBase.clickToElement(nameButton);
        attachScreenshot();
    }

    @Когда("пользовать выбирает запись по ключу")
    public void пользоватьВыбираетЗаписьПоКлючу() {
    }

    @И("пользователь нажимает на кнопку Comment")
    public void пользовательНажимаетНаКнопкуComment() {
    }

    @Тогда("пользователь печатает комментарий {string}")
    public void пользовательПечатаетКомментарий(String arg0) {
    }

    @И("пользовать нажимает на кнопку Add")
    public void пользоватьНажимаетНаКнопкуAdd() {
    }

    @Тогда("проверяется добавленный комментарий")
    public void проверяетсяДобавленныйКомментарий() {
    }


}
