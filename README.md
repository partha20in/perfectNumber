# Perfect Number finder Spring Boot Application #

### Project Overview ###

To build a simple  microservice running on the JVM and embedded webserver jetty ,build automation tool Gradle, and it manages to take a 
number or range of numbers and find the Perfect Number list.

### Application structure ###

The application is implemented as a Spring Boot application and have two REST API's of HTTP.GET type ,which validates a number is Perfect 
Number or not and also to find a list of numbers among a range of numbers which are Perfect Numbers in the range provided.
The application is structured in a controller package with a PerfectNumberSearchController, that exposes multiple REST endpoints.
The main implementation is done in PerfectNumberSearchService class.
The main class in the application is com.worldline.perfectnumber.PerfectNumberApplication. Running this class will start the Springboot application.
Unit test is implemented in PerfectNumberSearchServiceTest class.


### Task ###
API list:
http://localhost:8080/swagger-ui.html (Swagger api for displaying API list and its design)
http://localhost:8080/app/api/v1/perfectNumbers/5 (API to validate a number is Perfect or not)
http://localhost:8080/app/api/v1/perfectNumbersRange/startNumber/1/endNumber/1000 (API to find list of Perfect numbers within a range of numbers)

Basic login details from web-browser:
username: worldline
password: worldline



To run in POSTMAN cURL:
curl -X GET \
  http://localhost:8080/v2/api-docs \
  -H 'Postman-Token: 17ecec10-cc7a-46c5-95e9-a08ef38edab0' \
  -H 'cache-control: no-cache'
  
  
  curl -X GET \
  http://localhost:8080/app/api/v1/perfectNumbers/6 \
  -H 'Postman-Token: fb0c1f0f-66d8-4d9c-b103-924b5d904edd' \
  -H 'cache-control: no-cache'
  
  curl -X GET \
  http://localhost:8080/app/api/v1/perfectNumbersRange/startNumber/1/endNumber/10000 \
  -H 'Authorization: Basic d29ybGRsaW5lOndvcmxkbGluZQ==' \
  -H 'Postman-Token: a9367fea-4745-44d0-a8c2-976e22f48b9d' \
  -H 'cache-control: no-cache'