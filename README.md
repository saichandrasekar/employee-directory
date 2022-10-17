# Application Name: Employee Directory employee-directory
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
2) Execute $ mvn clean install
3) Run **_src/main/java/com/sai/backend/BackendApplication.java_** as Java Application

## Swagger Console

### Steps to open Swagger API

1) Open https://editor.swagger.io/
2) Import the file using Menu -> File -> Import
3) Select the yaml file inside /swagger in source code directory.

## App Monitoring & Status:

### Liveness check

```
http://localhost:8080/backend/v1/isalive
```
