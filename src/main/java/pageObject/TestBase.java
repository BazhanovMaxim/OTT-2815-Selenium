package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import filesUtils.ReadFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

public class TestBase extends BasePage {

    private ReadFile readFile;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    static String pageTitle;

    private final Reflections reflections = new Reflections("pageObject");
    final Set<Class<? extends BasePage>> arrayListClasses = reflections.getSubTypesOf(BasePage.class);

    public TestBase(){
        PageFactory.initElements(webDriver, this);
    }

    public void openURL(){
        BasePage.initialization();
    }

    public void EnterValueToFill(String inputToFill, String text){
        readFile = new ReadFile();
        String nameFile = getPageTitle();
        Class<?> getClassElements = getPage(nameFile);
        String elementSelectorID = getFieldsByAnnotation(getClassElements, inputToFill, "id");
        if (elementSelectorID.equals("null"))
            webDriver.findElement(By.className(getFieldsByAnnotation(getClassElements, inputToFill, "class"))).sendKeys(text);
        else webDriver.findElement(By.id(elementSelectorID)).sendKeys(text);
    }

    public void clickToElement(String elementToClick){
        readFile = new ReadFile();
        String nameFile = getPageTitle();
        Class<?> getClassElements = getPage(nameFile);
        String elementSelectorID = getFieldsByAnnotation(getClassElements, elementToClick, "id");
        System.out.println(elementSelectorID);
        if (elementSelectorID.equals("null"))
            webDriver.findElement(By.className(getFieldsByAnnotation(getClassElements, elementToClick, "class"))).click();
        else webDriver.findElement(By.id(elementSelectorID)).click();
    }

    /**
     * В arrayListClasses добавляем все классы, дальше проходим по каждому классу и смотрим его аннотацию
     * PageEntry, если она совпадает и названием страницы, то передаём Class и обьект класса в методы
     * Дальше отправляем в метод getFieldsByAnnotation, где возвращаем Id или Class элемента
     */

    public Class<?> getPage(String namePage){

        for (Class<?> class_1 : arrayListClasses){
            Annotation[] annotations = class_1.getAnnotations();
            for (Annotation annotation : annotations){
                PageEntry myAnnotation = (PageEntry) annotation;
                if (myAnnotation.PageTitle().equals(namePage)) {
                    return class_1;
                }
            }
        }
        return null;
    }

    /**
     * Получаем класс страницы и обьект, ищем поля, которые нам нужна для работы
     * @param Class класс страницы, полученный из метода test
     */

    public String getFieldsByAnnotation(Class<?> Class, String equalsElement, String selector){
        for (Field field : Class.getDeclaredFields()){
            if (field.isAnnotationPresent(ElementTitle.class)){
                ElementTitle elementTitle = (ElementTitle) field.getAnnotation(ElementTitle.class);
                if (elementTitle.ElementTitle().equals(equalsElement)) {
                    FindBy findBy = (FindBy) field.getAnnotation(FindBy.class);
                    if (selector.equals("id")) return findBy.id();
                    else return findBy.className();
                }
            }
        }
        return null;
    }
}
