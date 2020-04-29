package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import filesUtils.ToJson;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reflections.Reflections;
import webDriver.ManageDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Рефлексия с pageObject и Selenium
 * <p>
 *  Created by m.bazhanov on 29.04.2020
 * </p>
 */
public class BasePage {

    private static String page;
    private ToJson toJson;
    private WebDriver webDriver = ManageDriver.getInstance();

    public String getPage() {
        return page;
    }

    public void setPage(String pageTitle) {
        BasePage.page = pageTitle;
    }

    public BasePage(){
        PageFactory.initElements(webDriver, this);
    }

    public void openUrl(){
        webDriver.get("http://localhost:8080/login.jsp");
    }

    /**
     * Получение информации о записи
     * @param nameFileToCreateJson название файла для создания отчёта
     * @param getMapDataUser словарь "ключ-значение" пользователя
     */
    public void getInfoIssue(String nameFileToCreateJson, List<?> getMapDataUser){
        toJson = new ToJson();
        HashMap<String, String> newList = new HashMap<>();
        for (Object getValue : getMapDataUser){
            Class<?> getClassElements = returnPage(getPage());
            String elementSelectorID = getValueByAnnotation(getClassElements, getValue.toString());
            String getText = ManageDriver.getInstance().findElement(By.cssSelector(elementSelectorID)).getText();
            newList.put(getValue.toString(), getText);
        }
        toJson.serialize(newList, nameFileToCreateJson);
    }

    /**
     * Выполнение JavaScript запросов в браузере
     */
    public void JSExecute() {
        WebDriver webDriver = ManageDriver.getInstance();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.getElementsByClassName('delete-comment')[0].style.opacity = '1';");
        js.executeScript("document.getElementsByClassName('delete-comment issue-comment-action')[0].click();");
    }

    /**
     * Поиск заголовка страницы.
     * @param titleOfPage заголовок страницы для проверки. Идёт обращание к методу
     *                    {@link BasePage#getValueByAnnotation(Class, String)}, откуда получение значение поля
     * @return возвращается заголовок страницы
     */
    public String getTitle(String titleOfPage){
        String nameFile = getPage();
        Class<?> getClassElements = returnPage(nameFile);
        return ManageDriver.getInstance().findElement(By.cssSelector(getValueByAnnotation(getClassElements, titleOfPage))).getText();
    }

    /**
     * Нажать на элемент по тексту
     * @param textSearch текст, который нужно найти и на который нужно кликлуть
     */
    public void clickToIssueByKeyOrSummary(String textSearch){
        ManageDriver.getInstance().findElement(By.xpath("//*[text()='" + textSearch + "']")).click();
    }

    /**
     * Заполнение поля значение
     * @param inputField получение поля, которое нужно заполнить
     * @param enteredValue получение текста, который нужно ввести в поле ввода
     */
    public void EnterValueToField(String inputField, String enteredValue){
        String nameFile = getPage();
        Class<?> getClassElements = returnPage(nameFile);
        String elementSelectorID = getValueByAnnotation(getClassElements, inputField);
        if (checkEnableElementById(elementSelectorID)){
            ManageDriver.getInstance().findElement(By.id(elementSelectorID)).click();
            ManageDriver.getInstance().findElement(By.id(elementSelectorID)).sendKeys(enteredValue);
        }
        else {
            ManageDriver.getInstance().findElement(By.id(elementSelectorID)).click();
            ManageDriver.getInstance().findElement(By.className(elementSelectorID)).sendKeys(enteredValue);
        }
    }

    /**
     * Проверка существование элемента на странице
     * @param locatorOfElementID локатор элемента (id)
     * @return булевое значение: true или false
     */
    public boolean checkEnableElementById(String locatorOfElementID){
        try {
            ManageDriver.getInstance().findElement(By.id(locatorOfElementID)).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Проверка существование элемента на странице
     * @param locatorOfElementClassName локатор элемента (className)
     * @return булевое значение: true или false
     */
    public boolean checkEnableElementByClass(String locatorOfElementClassName){
        try {
            ManageDriver.getInstance().findElement(By.className(locatorOfElementClassName)).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Проверка существование элемента на странице
     * @param locatorOfElementXpath локатор элемента (xpath)
     * @return булевое значение: true или false
     */
    public boolean checkEnableElementByXpath(String locatorOfElementXpath){
        try {
            ManageDriver.getInstance().findElement(By.xpath(locatorOfElementXpath)).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * Нажатие на элемент (click())
     * @param elementToClick принимает значение (id, className, xpath, css) элемента
     */
    public void clickToElement(String elementToClick){
        String nameFile = getPage();
        Class<?> getClassElements = returnPage(nameFile);
        String elementSelectorID = getValueByAnnotation(getClassElements, elementToClick);
        if (checkEnableElementById(elementSelectorID)) {
            try{
                ManageDriver.getInstance().findElement(By.id(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                ManageDriver.getInstance().findElement(By.id(elementSelectorID)).click();
            }
        } else if (checkEnableElementByClass(elementSelectorID)){
            try{
                ManageDriver.getInstance().findElement(By.className(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                ManageDriver.getInstance().findElement(By.className(elementSelectorID)).click();
            }
        } else if (checkEnableElementByXpath(elementSelectorID)){
            try{
                ManageDriver.getInstance().findElement(By.xpath(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                ManageDriver.getInstance().findElement(By.xpath(elementSelectorID)).click();
            }
        }
        else {
            try{
                ManageDriver.getInstance().findElement(By.cssSelector(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                ManageDriver.getInstance().findElement(By.cssSelector(elementSelectorID)).click();
            }
        }
    }

    /**
     * При помощи аннотации и рефлексии идёт поиск нужно страницы и элемент, если 
     * элемент найден, то возвращается класс страницы
     * @param namePage Название страницы, на которой нужно найти элемент
     * @return возвращается класс страницы, если элемент найден
     */
    public Class<?> returnPage(String namePage){
        final Reflections reflections = new Reflections("pageObject");
        final Set<Class<? extends BasePage>> arrayListClasses = reflections.getSubTypesOf(BasePage.class);
        for (Class<?> objectOfClass : arrayListClasses){
            Annotation[] annotations = objectOfClass.getAnnotations();
            for (Annotation annotation : annotations){
                PageEntry myAnnotation = (PageEntry) annotation;
                if (myAnnotation.PageTitle().equals(namePage)) {
                    return objectOfClass;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param Class принимает класс, в котором нужно найти элемент
     * @param equalsElement принимает элемент. с которым нужно сравнить название. Если название совпадает -
     *                      - то возвращается значение (id, className, xpath, css) элемента
     * @return возвращается значение (id, className, xpath, css) элемента
     */
    public String getValueByAnnotation(Class<?> Class, String equalsElement){
        for (Field field : Class.getDeclaredFields()){
            if (field.isAnnotationPresent(ElementTitle.class)){
                ElementTitle elementTitle = (ElementTitle) field.getAnnotation(ElementTitle.class);
                if (elementTitle.ElementTitle().equals(equalsElement)) {
                    FindBy findBy = (FindBy) field.getAnnotation(FindBy.class);
                    if ((findBy.id().equals("")) && (findBy.xpath().equals("")) && (findBy.css().equals(""))) {
                        return findBy.className();
                    }
                    else if ((findBy.className().equals("")) && (findBy.xpath().equals("")) && (findBy.css().equals(""))) {
                        return findBy.id();
                    }
                    else if ((findBy.className().equals("")) && (findBy.id().equals("")) && (findBy.css().equals(""))){
                            return findBy.xpath();
                    }
                    else{
                        return findBy.css();
                    }
                }
            }
        }
        return null;
    }
}
