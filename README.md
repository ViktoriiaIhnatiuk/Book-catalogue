# Book-catalogue
_____________________________
This web application imitates the work of the simple book catalogue.

Project structure
-----------
Application is designed according to SOLID, REST principles, using DI and N-Tier Architecture patterns with next layers:
1. controllers layer;
2. services layer;
3. repositories layer;

Features
-----------
1. Create/update/delete author
2. Display all authors
3. Display author by id
4. Display the most successful author (successAuthorRate = sum of all
   successBookRate/number of books) with author's successAuthorRate
5. Create/update/delete book
6. Display all books
7. Display book by id
8. Display all books by author's name
9. Display the most selling book for requested author's name
10. Display the most published book for requested author's name
11. Display a list of most selling books using partial search by author's name
12. Display a list of most published books using partial search by author's name
13. Display a list of most successful books by author's name (successBookRate =
    soldAmount/publishedAmount) using partial search by author's name
14. Display TOP N most-selling books by concrete author's name
15. Display TOP N most-published books by concrete author's name
16. Display TOP N most-successful books by concrete author's name

Technologies
-----------
* Java 11
* Spring Boot
* Apache Maven
* Swagger
* MySQL

Usage
-----------
1. Install IntelliJ IDEA ultimate version;
2. Clone this project from GitHub and make sure that an absolute path doesn't include any white spaces and/or non-Latin
   symbols;
4. Install MySQL and MySQL Workbench;
6. Configure application.properties file to make a connection to you DB;
7. Run application;
8. Test application using postman, swagger ui by url http://localhost:8080/swagger-ui/# and/or your browser address bar

List of allowed http methods with available endpoints
-----------
```
POST: /authors
PUT: /authors/{id}
GET: /authors
GET: /authors/{id}
DELETE: /authors/{id}
GET: /authors//most-successful
POST: /books
PUT: /books/{id}
GET: /books
GET: /books/{id}
DELETE: /books/{id}
GET: /books/by-author
GET: /books//most-selling
GET: /books//most-published
GET: /books/most-selling/by-author-name-partial
GET: /books/most-published/by-author-name-partial
GET: /books/most-successful/by-author-name-partial
GET: /books/top-selling/by-author
GET: /books/top-published/by-author
GET: /books/top-successful/by-author
```
_____________________________
* All incoming and outgoing data converted to JSON format.


