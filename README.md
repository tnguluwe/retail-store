# About retail-store project
Retail store project to demonstrate tech usage 

# Project execution
- There are 2 ways to run project:
    1. Using an IDE like intellij run the class RetailStoreApplication.java
    2. Run ```mvn clean install``` on command line. It will create a java file and install it on your local M2 repository folder. Find that jar full path on the command line and execute it with command ```java -jar {home-directory}\.m2\repository\com\retail\store\retail-store\0.0.1-SNAPSHOT\retail-store-0.0.1-SNAPSHOT.jar```
  
# General Info
- Since its development enviroment, we are using spring developer tools library that allows for hot deploy of our changes. Simply rebuild the project or compile the changed class if running in an IDE liek IntelliJ to initiate the hot deploy.

# Important links
- Access Swagger on URL localhost:8080/swagger-ui.html ![image](https://user-images.githubusercontent.com/112032938/189241168-1c28e661-5c80-4f69-86c6-bd86eb9c07db.png)
- Access the OpenAPI description on URL http://localhost:8080/v3/api-docs ![image](https://user-images.githubusercontent.com/112032938/189241410-f308f94b-9688-4898-b9c7-d5a4032ee01e.png)
- Monitor Spring application on URL http://localhost:8080/actuator. (Note: I am using a JSON-Viewer Chrome plugin) ![image](https://user-images.githubusercontent.com/112032938/189241556-1bb26d97-448c-46ae-a55e-7ec0b8bd51f6.png)



