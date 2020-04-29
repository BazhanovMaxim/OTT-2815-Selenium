# language:ru
@DeleteComments
Функционал: Удаление комментария
  Пользователь должен зайти на сайт
  Пользователь зайти на страницу записи и удалить комментарии (API и UI)
  Пользователь должен выйти из системы

  Сценарий: Удаление комментария
    Дано открывается страница "Welcome to Jira"
    Когда пользователь вводит свои данные
      |LoginField   |rb076623|
      |PasswordField|Zxcvbnm1|
    И пользователь нажимает на кнопку "LogIn"
    Тогда открывается страница "System Dashboard"

    # Проверка через Status Code
    Тогда Удаляется комментарий через API

    # Удаление комментария через UI
    Тогда пользователь нажимает на "Навигационная панель" на кнопку "Issue"
    И пользователь нажимает на кнопку "Reported By Me"
    Тогда открывается страница "Reported by me"
    Когда пользователь выбирает запись по ключу "MAX-2"
    И пользователь при помощи JS нажимает на элемент
    Тогда открывается страница "Delete Comment"
    Тогда пользователь нажимает на кнопку "Delete"

    Тогда пользователь нажимает на "Навигационная панель" на кнопку "User profile"
    И пользователь нажимает на кнопку "LogOut"