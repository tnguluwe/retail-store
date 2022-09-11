# About retail-store project
A retail store micro-service to showcase how to:
1. Setup a micro-service using SpringBoot.
2. Setup and build a SpringBoot project using maven.
3. Use Swagger-3 and OpenAPI-3 to document a rest endpoint.
4. Monitor a SpringBoot application using actuator.
5. Setup application ```hot deployment``` (deploy changes and auto-restarts the Spring container) on a Development environment, using Spring DevTools. ```Note:``` This is not recommended for Production environment.
6. Unit test an application using JUnit 5.
7. Test a REST API endpoint using Spring integration tests.

# Project execution
- There are 2 ways to run project:
    1. Using an IDE like intellij run the class RetailStoreApplication.java
    2. Run ```mvn clean install``` on command line. It will create a java file and install it on your local M2 repository folder. Find that jar full path on the command line and execute it with command ```java -jar {home-directory}\.m2\repository\com\retail\store\retail-store\0.0.1-SNAPSHOT\retail-store-0.0.1-SNAPSHOT.jar```
  
# General Info
- Since its development enviroment, we are using spring developer tools library that allows for hot deploy of our changes. Simply rebuild the project or compile the changed class if running in an IDE like IntelliJ to initiate the hot deploy.

# Important links
- Access Swagger on URL localhost:8080/swagger-ui.html ![image](https://user-images.githubusercontent.com/112032938/189245797-aebfdaaa-7807-4ec5-9d03-8c56aa4784aa.png)
- Access the OpenAPI description on URL http://localhost:8080/v3/api-docs ![image](https://user-images.githubusercontent.com/112032938/189241410-f308f94b-9688-4898-b9c7-d5a4032ee01e.png)
- Monitor Spring application on URL http://localhost:8080/actuator. (Note: I am using a JSON-Viewer Chrome plugin) ![image](https://user-images.githubusercontent.com/112032938/189241556-1bb26d97-448c-46ae-a55e-7ec0b8bd51f6.png)



