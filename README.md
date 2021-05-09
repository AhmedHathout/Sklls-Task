# Sklls-Task
This is a showcase project that is implemented using Spring Boot, Angular 
and Postgres. The user can use the app to store adn retrieve some information 
about the clients. Retrieving the data can be done using the browser but 
adding (posting) new data can only be done by a REST-API client (e.g. postman). 

### Requirements to run the app
1. JDK 16 (used 16 here. However, 11 should run it but I did not test it on 11)
1. Angular (used Angular 11)
1. Postgres
### How to run and use the app
1. Replace the current parameters for the database in the 3 `application.
   properties` files with the real ones. These are:-
   1. `spring.datasource.username`
   1. `spring.datasource.password`
   1. `spring.datasource.url`
    
   Note: You can either replace them in these 3 files or delete them and 
   have them as parameters when you run the application every time or as 
   environment variables.
1. (Optional) set `spring.profiles.active` to the profile you prefer in 
   `application.
   properties`. You can also delete it and do the same that you did for 
   database parameters
1. Run postgres server.
1. Run the backend after the database server is up.
1. Insert at least one user in the database. This is the user that can read
   and store the data in the application
1. Run the frontend after the backend is up.
1. Use that user to log in
1. You should see an empty table now that has the columns `name`, `email` 
   and `location`.
1. To insert new data in the table, make a `POST` request to the end point 
   `http://localhost:8080/api/person` with a request body of `firstName`, 
   `lastName`, `email` and `location`. All the fields must not be blank and 
   the email look like a valid email address. For authentication, use 
   `Basic Auth`.     This can be done easily in postman by selecting `Basic 
   Auth` in the `Authorization` tab. Fill in the username and password of the user that 
   was created previously in the database. The table now should have one 
   extra entry.
   
Note that both the frontend and the backend should run on ports `4200` and 
`8080` respectively on the localhost. 
