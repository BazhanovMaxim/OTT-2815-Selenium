package TestRefl;

import annotations.ElementTitle;
import annotations.PageEntry;
import org.openqa.selenium.support.FindBy;
import pageObject.AuthPage;
import pageObject.LogOut;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class test_1{

    /**
     * В ArrayList добавляем все классы, дальше проходим по каждому классу и смотрим его аннотацию
     * PageEntry, если она совпадает и названием страницы, то передаём Class и обьект класса в методы
     * @throws IllegalAccessException
     * @throws InstantiationException
     */

    public void test() throws IllegalAccessException, InstantiationException {

        ArrayList<Class<?>> arrayListClasses = new ArrayList<>();
        arrayListClasses.add(AuthPage.class);
        arrayListClasses.add(LogOut.class);

        for (Class<?> class_1 : arrayListClasses){
            Annotation[] annotations = class_1.getAnnotations();
            for (Annotation annotation : annotations){
                PageEntry myAnnotation = (PageEntry) annotation;
                if (myAnnotation.PageTitle().equals("Страница авториации")) {
                    getFieldsByAnnotation(class_1, class_1.newInstance());
                    // Для метода: getMethods_2(class_1, class_1.newInstance());
                }
            }
        }
    }

    /**
     * Получаем класс страницы и обьект, ищем поля, которые нам нужна для работы
     * @param Class класс страницы, полученный из метода test
     * @param obj обьект страницы для работы с методами
     */

    public void getFieldsByAnnotation(Class<?> Class, Object obj){
        for (Field field : Class.getDeclaredFields()){
            // Определяем все поняли с Аннотацией ElementTitle
            if (field.isAnnotationPresent(ElementTitle.class)){
                ElementTitle elementTitle = (ElementTitle) field.getAnnotation(ElementTitle.class);
                if (elementTitle.ElementTitle().equals("Логин")) {
                    System.out.println("Название элемента: " + elementTitle.ElementTitle());
                    System.out.println("Названия поля: " + field.getName());
                    getField(Class, obj, field.getName());
                }
            }
        }
    }

    public void getField(Class<?> Class, Object obj, String nameField) {
        String getValueIdOrClassName = null;
        for (Field field : Class.getDeclaredFields()) {
            if (field.getName().equals(nameField)){
                FindBy findBy = (FindBy) field.getAnnotation(FindBy.class);
                if (findBy.className().equals("")) getValueIdOrClassName = findBy.id();
                else getValueIdOrClassName = findBy.className();
            }
        }
        System.out.println("Айди или Класс элемента: " + getValueIdOrClassName);
    }

    /**
     * Ищем метод по названию его и запускаем
     * @param Class
     */
    //public void getMethods_2(Class<?> Class_element, Object obj){
    //    try{
    //        Method getMethod = Class_element.getMethod("testVoid");
    //        System.out.println("new tryL " + getMethod.invoke(obj));
    //    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
    //        e.printStackTrace();
    //    }
    //}

}
