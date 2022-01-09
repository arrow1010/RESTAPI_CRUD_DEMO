# RESTAPI_CRUD_DEMO

#Hi friends
I have created a demo rest api that performs all crud operations

how to use ?
-Download and import project in your IDE
-Open TableScript.sql file and import it in your db software 
-update db url, password, port in application.properties file
-run and test api

how to test ?
-Get all students - localhost:8765/studentApp/
-Get student by id - localhost:8765/studentApp/1
-Add student - localhost:8765/studentApp/addStudent  
      request body =
    {
    "studentId": 3,
    "name": "Abhishek Singh",
    "email": "abhi@infy.com"
}

-Delete student - localhost:8765/studentApp/deleteStudent/3

-Update Student - - localhost:8765/studentApp/updateStudent/4
{
    "studentId": ,
    "name": "King",
    "email": "abhi@infy.com"
}
