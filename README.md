# Application Name: Employee Directory (employee-directory:1.0.0)
A sample web application to add, edit and delete employee information

## Technical Stack:

```
Java JDK 8
Spring Boot 2.7.4
H2 Database
Swagger Docs OpenAPI Specification version 3
```

## Source Code Structure:

- /backend - Spring Boot REST API 
  - src/main/java
    - com/sai/backend - Base Package and Main Spring Boot Application 
    - com/sai/backend/viewobject - Java Beans for JSON view objects.
    - com/sai/backend/controller - Employee and Department REST Controller    
    - com/sai/backend/service - Employee and Department DB Service Classes
    - com/sai/backend/service/impl - Service Implementation
    - com/sai/backend/entity -  Employee and Department JPA Entity    
    - com/sai/backend/repository - Database JPA DAO interfaces 
    - com/sai/backend/util - App utility classes    
    - com/sai/backend/exceptions - App Exception classes
  - src/main/resources - application.properties and data.sql
    
    
- /swagger - swagger yaml file for testing


## Developer Box Setup:

### Eclipse IDE or IntelliJ:

1) Import the source code in /backend directory as maven project
2) Execute $ **_mvn clean install_**
3) Run **_src/main/java/com/sai/backend/BackendApplication.java_** as Java Application

## Swagger Console

### Steps to open Swagger API

1) Open https://editor.swagger.io/
2) Import the file using Menu -> File -> Import
3) Select the yaml file inside **_/swagger_** in source code directory.

## App Monitoring & Status:

### Liveness check

```
http://localhost:8080/backend/v1/isalive
```

## H2 Database Console

### Browser client to query the database

```
http://localhost:8080/h2-console
```
- **JDBC URL** : jdbc:h2:mem:mayurdb
- **User Name** : dba
- **Password** : dba


## Testing

> Below are few API examples, refer to swagger for more detailed documentation.

### Create Department

URL: **POST** http://localhost:8080/backend/v1/department

Input:
```
{  
  "departmentName": "IT",
  "managerId": 1
}
```

Output:
```
{
  "departmentId": 7,
  "departmentName": "IT",
  "managerId": 1
}
```
___________________________________________________________________________________________________________________________________________________________________

### Fetch Department with Pagination

URL: **GET** http://localhost:8080/backend/v1/department/page/0/size/2


Output:
```
[
  {
    "departmentId": 1,
    "departmentName": "ADMIN",
    "managerId": 1
  },
  {
    "departmentId": 2,
    "departmentName": "IT",
    "managerId": 2
  }
]
```
___________________________________________________________________________________________________________________________________________________________________

### Create Employee

URL: **POST** http://localhost:8080/backend/v1/employee

Input:
```
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "abc@foobar.co",
  "phoneNumber": "917-658-9865",
  "hireDate": "2022-10-25T00:00:00.000+00:00",
  "salary": 45.41,
  "managerId": 1,
  "departmentId": 2
}
```

Output:
```
{
  "employeeId": 10,
  "firstName": "John",
  "lastName": "Doe",
  "email": "abc@foobar.co",
  "phoneNumber": "917-658-9865",
  "hireDate": "2022-10-25T00:00:00.000+00:00",
  "salary": 45.45,
  "managerId": 1,
  "departmentId": 2
}
```
___________________________________________________________________________________________________________________________________________________________________

### Fetch Employees with Pagination

URL: **GET** http://localhost:8080/backend/v1/employee/page/0/size/2

Output:
```
[
  {
    "employeeId": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john_doe@mayur.com",
    "phoneNumber": "917-852-9865",
    "hireDate": "2022-10-17T18:30:00.000+00:00",
    "salary": 5698.2,
    "managerId": null,
    "departmentId": 1
  },
  {
    "employeeId": 2,
    "firstName": "Sam",
    "lastName": "Nickel",
    "email": "sam_nickel@mayur.com",
    "phoneNumber": "917-456-9865",
    "hireDate": "2022-10-17T18:30:00.000+00:00",
    "salary": 8795.5,
    "managerId": null,
    "departmentId": 2
  }
]
```
___________________________________________________________________________________________________________________________________________________________________

### Fetch Employee By Id

URL: **GET** http://localhost:8080/backend/v1/employee/2

Output:
```
{
  "employeeId": 2,
  "firstName": "Sam",
  "lastName": "Nickel",
  "email": "sam_nickel@mayur.com",
  "phoneNumber": "917-456-9865",
  "hireDate": "2022-10-17T18:30:00.000+00:00",
  "salary": 8795.5,
  "managerId": null,
  "departmentId": 2
}
```

## API Request Validations

> Request data validations are implemented using Spring Javax Validators. Any error in request data will result in **_400 Bad Request_ HTTP Status**

### Employee - First Name should not be null

### Employee - First Name should be more than 2 characters

### Employee - Last Name should not be null

### Employee - Last Name should be more than 2 characters

### Employee - Salary is greater than 0

### Employee - Phone number contain only digits and dashes


