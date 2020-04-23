package pageObject;

import annotations.ElementTitle;
import annotations.PageEntry;
import filesUtils.ReadFile;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

public class TestBase{

    private ReadFile readFile = new ReadFile();
    private static String pageTitle;
    private ManageDriver manageDriver = ManageDriver.getInstance();
    public WebDriver webDriver_1 = manageDriver.webDriver;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        TestBase.pageTitle = pageTitle;
    }

    public TestBase(){
        PageFactory.initElements(webDriver_1, this);
    }

    public void closeDriver(){
        webDriver_1.quit();
    }

    public String getTitle(String title){
        String nameFile = getPageTitle();
        Class<?> getClassElements = getPage(nameFile);
        return webDriver_1.findElement(By.cssSelector(getFieldsByAnnotation(getClassElements, title))).getText();
    }

    public void EnterValueToFill(String inputToFill, String text){
        String nameFile = getPageTitle();
        Class<?> getClassElements = getPage(nameFile);
        String elementSelectorID = getFieldsByAnnotation(getClassElements, inputToFill);
        if (checkEnabledElementById(elementSelectorID))
            webDriver_1.findElement(By.id(getFieldsByAnnotation(getClassElements, inputToFill))).sendKeys(text);
        else webDriver_1.findElement(By.className(elementSelectorID)).sendKeys(text);
    }

    public boolean checkEnabledElementById(String element){
        try {
            webDriver_1.findElement(By.id(element)).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean checkEnabledElementByClass(String element){
        try {
            webDriver_1.findElement(By.className(element)).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean checkEnableElementByXpath(String element){
        try {
            webDriver_1.findElement(By.xpath(element)).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void clickToElement(String elementToClick){
        String nameFile = getPageTitle();
        Class<?> getClassElements = getPage(nameFile);
        String elementSelectorID = getFieldsByAnnotation(getClassElements, elementToClick);
        if (checkEnabledElementById(elementSelectorID)) {
            try{
                webDriver_1.findElement(By.id(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                webDriver_1.findElement(By.id(elementSelectorID)).click();
            }
        } else if (checkEnabledElementByClass(elementSelectorID)){
            try{
                webDriver_1.findElement(By.className(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                webDriver_1.findElement(By.className(elementSelectorID)).click();
            }
        } else if (checkEnableElementByXpath(elementSelectorID)){
            try{
                webDriver_1.findElement(By.xpath(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                webDriver_1.findElement(By.xpath(elementSelectorID)).click();
            }
        }
        else {
            try{
                webDriver_1.findElement(By.cssSelector(elementSelectorID)).click();
            } catch (StaleElementReferenceException e){
                webDriver_1.findElement(By.cssSelector(elementSelectorID)).click();
            }
        }
    }

    /**
     * В arrayListClasses добавляем все классы, дальше проходим по каждому классу и смотрим его аннотацию
     * PageEntry, если она совпадает и названием страницы, то передаём Class и обьект класса в методы
     * Дальше отправляем в метод getFieldsByAnnotation, где возвращаем Id или Class элемента
     */

    public Class<?> getPage(String namePage){
        final Reflections reflections = new Reflections("pageObject");
        final Set<Class<? extends TestBase  >> arrayListClasses = reflections.getSubTypesOf(TestBase.class);
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

    public String getFieldsByAnnotation(Class<?> Class, String equalsElement){
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
