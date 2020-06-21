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


### Action with quiz
```
POST   /quiz/create
POST   /quiz/update
{
    "name": "MembersWish", // [required] string 
    "status": "Active", // [required] string 
    "startDate": "20190813T2345", // [required] date in format YYYYMMDD'T'HHmm
    "finishDate": "20190813T2346" // [required] date in format YYYYMMDD'T'HHmm

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



