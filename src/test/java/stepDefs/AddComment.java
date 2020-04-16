package stepDefs;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;


public class AddComment {
    @Тогда("отправляется запрос на добавления комментария")
    public void отправляетсяЗапросНаДобавленияКомментария() {

    }

    @Когда("пользователь нажимает на навигационную панель на Issue")
    public void пользовательНажимаетНаНавигационнуюПанельНаIssue() {
    }

    @И("пользователь нажимает на Reported By Me")
    public void пользовательНажимаетНаReportedByMe() {
    }

    @Тогда("пользователь на странице {string}")
    public void пользовательНаСтранице(String arg0) {
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

    @И("пользователь выходит из системы")
    public void пользовательВыходитИзСистемы() {
    }
}
