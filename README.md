# SpringBoot-Rest-API-MySQL
A simple RestAPI Using SpringBoot and MySQL

 - Start the application, Runs on port 8082
 - Dependencies Used
    * Spring Data JPA
    * Spring Web
    * MySQL Driver
    * Lombok <br>
    (Refer [offical doumentation](https://projectlombok.org/) to install lombok in your IDE )
    
 - MySQL Database info:
    * Name of the database : ```projects``` <br>
   Run this below query to create a database in your MYSQL. <br>
   ```CREATE DATABASE projects``` <br><br>
    * Name of the table    : ```employee``` <br>
    Table gets auto created when the application is started.

 - JSON Format used to transfer is as below (employeeId is Auto Generated)
```
{
    "firstName": "User",
    "lastName": "Name",
    "email": "UserN@outlook.com",
    "phoneNumber": 124585965,
    "hireDate": "22-04-2002",
    "salary": 1524.044
}
```
