# EmplyoeePortal
## Content Of this File
* Introduction
* Prerequisties
* Installation 
* Configuration
* Build and Run
* Tset Case

### Introduction
EmplyoeePortal Application is to add employee and get all existing Employee
this is only backend implementation.

### Prerequisties
* Java 8
* Spring Boot
* REST API
* Swagger
* Junit
* Mockito

### Installation
* Java 8 or above references
* Eclipse or STS
* Postman

### Configuration
1- Import this spring boot project to STS or Eclipse ( IDE -> File -> Import -> Git -> Project from git -> Existing Local Repository -> add -> Browse to Folder -> next  -> next -> finish * Build the project)

2- Add JUint 5 Library to Build path ( right click on Project -> Build Path -> Configure Build Path -> Liberaries -> Add Library -> Select JUnit -> next -> Select JUnit 5 -> finish -> Apply and Close )

### Build and run

1- IDE -> menu -> project -> clean 
2- IDE -> menu -> project -> build project
3 - Run as Spring Boot App


### Test Cases
  1- Test case
 *  send http://localhost:8080/v2/api-docs request get the api Document or open http://localhost:8080/swagger-ui.html in browser to get api document
 * check the request body for http://localhost:8080/api/register 
 *  send post http://localhost:8080/api/register request with json (firstName, lasrName, dateOfBirth, Department, gender)
 * verify - verify the status and response should be the same
 
 2 - Test case
  * send http://localhost:8080/api/employess request get the list of employees
  * Verify - list should display all employees in ascending order by first name
