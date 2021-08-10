# Airports

### This is a free project for manage flight.

It uses Spring Boot 2.5.1, Maven, Postgresql, Bootstratp 5

Install postgresql, and create a database called `airports`.
Inside the `src/main/resources/application.properties` file set the URI for the database, the username and password.

To use it, simply copy the project files in your computer, and under the project path use the command:
  
> `mvn dependency:resolve`

- After downloading dependencies, you neeed to execute command:
`mvn package`
to build the project.

- for starting the server type `mvn spring-boot:run `
- after the server started, in the browser address field type `http://localhost:8080/home` to acces the application

After the aplication started create a user, then form a database manager application you have to change the user role to ADMIN, to acces all the features of the application.

You are good to go

Enjoy 