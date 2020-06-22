URL http://localhost:8300
http://localhost:8300/swagger-ui.html
### Action with question
Sends
```
POST /question/create
{
    "nameQuiz": "MembersWish", // [required] string 
    "text": "Text", // [required] string 
    "order": "12" // [required] int 

}
```

```
POST /question/update
{
    "nameQuiz": "MembersWish", // [required] string 
    "text": "Text", // [required] string 
    "order": "12" // [required] int 

}
```

```
DELETE /question/delete
{
    "nameQuiz": "MembersWish", // [required] string 
    "position": "11" // [required] int 

}
```
Returns 

```
POST /question/read
[
    {
         "id": "1", // [required] int 
         "link": "1", // [required] int
         "text": "Question", // [required] string 
         "order": "1" // [required] int
    }
]

```

### Action with quiz
Sends
```
POST   /quiz/create
{
    "name": "MembersWish", // [required] string 
    "status": "Active", // [required] string 
    "startDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HH:MM:ss[.ммм]
    "finishDate": "2012-04-22T20:00:00.000+00:00" // [required] date in format YYYYMMDD'T'HH:MM:ss[.ммм]
YYYYMMDD'T'HHmm
}
```
```
POST   /quiz/update
{
    "name": "MembersWish", // [required] string 
    "status": "Active", // [required] string 
    "startDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HH:MM:ss[.ммм]
    "finishDate": "2012-04-22T20:00:00.000+00:00" // [required] date in format YYYYMMDD'T'HH:MM:ss[.ммм]

}
```
```
DELETE /quiz/delete
{
    "name": "MembersWish" // [required] string 
}
```
```
POST  /quiz/cancel
{
    "name": "MembersWish" // [required] string 
}
```
Returns 

```
POST  /quiz/read
[
    {
        "id": 69, // [required] int 
        "name": "MembersWish02", // [required] string
        "startDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HH:MM:ss[.ммм]
        "finishDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HH:MM:ss[.ммм]
        "status": "Active", // [required] string
        "questionEntities": [
            {
                "id": "1", // [required] int 
                "link": "1", // [required] int
                "text": "Question", // [required] string 
                "order": // [required] int
            }
        ]
    }
]
```

All questionnaires are unique. 
All questions in questionnaires are unique.
You can add date in order.
--------------------
Задание
--------------------

Необходимо создать REST - сервис для управления справочными данными.

Структура данных:
Опрос
--------------------
Наименование опроса

Дата начала

Дата окончания

Активность (да/нет)

Вопрос опроса
--------------------
Ссылка на опрос

Текст вопроса

Порядок отображения


REST-сервис должен предоставлять следующие методы: - Получить все опросы (Опцио-нально можно передать фильтр по наименованию, дате, активности. Обязательно указание сортировки: по наименованию или по дате начала опроса. Должна поддерживаться пагина-ция.) - Создание опроса - Редактирование опроса - Удаление опроса
Сервис должен предоставлять документацию с использованием Swagger. Сервис при первом запуске должен самостоятельно создавать необходимые объекты в БД с помощью Liquibase. Необходимо использовать PostgreSQL.
Для реализации необходимо использовать Java 8, Spring Boot, Hibernate, PostgreSQL, Liquibase. Исходный код загрузить в GitHub и в описании указать краткую инструкцию по запуску приложения.
