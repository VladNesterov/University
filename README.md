### Action with question
```
POST /question/create
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
         "order": // [required] int
    }
]

```

### Action with quiz
```
POST   /quiz/create
POST   /quiz/update
{
    "name": "MembersWish", // [required] string 
    "status": "Active", // [required] string 
    "startDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HHmm
    "finishDate": "2012-04-22T20:00:00.000+00:00" // [required] date in format YYYYMMDD'T'HHmm

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
        "startDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HHmm
        "finishDate": "2012-04-22T20:00:00.000+00:00", // [required] date in format YYYYMMDD'T'HHmm
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

