# Разработка фреймворка для автоматизированного тестирования

## Используемые средства: JUnit4, Selenium, Cucumber, Allure, rest-assured, gson

## Требования к фреймворку:
* Поддержка BDD тестов, используя фрейворк Selenide (по желанию)
* Поддержка тестирования WEB, Rest API
* Формировать отчёт Yandex Allure
* Делать скриншот состояния тестируемой системы на каждом шаге и добавлять его в Allure отчёт (когда применимо)
* Прикреплять файл с ответом REST сервера к Allure отчёту (когда применимо)
* Записывать логи запуска теста в файл и в консоль

## Подготовить набор тест-кейсов для автоматизации, основанный на списке функциональных требований к продукту
* Набор тест-кейсов покрывает все функциональные требования к тестируемому продукту

## Реализовать набор тестовых сценариев на основе BDD подхода
* Согласно сформированному набору тест-кейсов сформировать набор BDD сценариев, готовых к автоматизации (например, на Gherkin)

## Тестируемая среда: 
* Web: Jira (localhost)
* REST: [Jira Server platform REST API reference](https://docs.atlassian.com/software/jira/docs/api/REST/8.8.1/)

## Функциональные требования:
* Авторизация
* Добавление нового комментария
* Удаление комментария
* Создание новой записи
* Удаление записи
* Обновление записи
* Получение информации о записи
* Получение информации о комментарии
* Выход из системы