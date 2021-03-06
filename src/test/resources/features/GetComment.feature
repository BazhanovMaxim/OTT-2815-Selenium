# language:ru
@GetComment
Функционал: Получение комментарии записи
  Пользователь должен авторизоваться
  Пользователь должен отправить запрос на получение информации о комментарии
  Пользователь должен зайти на страницу с выбранной записью и получить информацию о комментариях

  Сценарий: Получение комментарии записи
    Дано открывается страница "Welcome to Jira"
    Когда пользователь вводит свои данные
      |LoginField   |rb076623|
      |PasswordField|Zxcvbnm1|
    И пользователь нажимает на кнопку "LogIn"
    Тогда открывается страница "System Dashboard"

    # Через API
    Тогда отправляется запрос на получение комментариев записи через API

    # Получени информации о комментариях (Key = MAXOAT-568)
    Тогда пользователь нажимает на "Навигационная панель" на кнопку "Issue"
    И пользователь нажимает на кнопку "Reported By Me"
    Тогда открывается страница "Reported by me"
    Когда пользователь выбирает запись по ключу "MAX-2"
    И пользователь записывает информацию о комментариях в "InfoAboutIssueCommentsUI.txt"

    Тогда пользователь нажимает на "Навигационная панель" на кнопку "User profile"
    И пользователь нажимает на кнопку "LogOut"