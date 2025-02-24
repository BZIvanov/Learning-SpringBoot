# H2 database demo

This demo contains only the essential files. Some of the boilerplate code files were removed for simplicity.

H2 is in-memory database, which means everytime we restart the server, the data will be wiped.

### H2 Connection

In this demo, we are using custom connection URL, so you can skip point 2.

1. **Custom connection URL**.

In `application.properties` you can find the connection URL, which you will need to connect to H2 Database after visiting the H2 console endpoint.

2. **Generic connection**

You will have to provide `JDBC URL` to be able to connect to the database. You can find your URL in the console after you start the application. In the console search for something like: _HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:b56ddfee-b49a-43cc-b443-c1ff8fcbe6c1 user=SA_. You need to copy only the _jdbc:h2:mem:b56ddfee-b49a-43cc-b443-c1ff8fcbe6c1_ part, which is your URL.

Now you should be able to Connect. You don't need to change the values for the other fields in the console.

## H2 Console

After starting the server, open `http://localhost:8080/h2-console` to view the H2 database console.

Run the below query to select data in the H2 console:

```sql
SELECT * FROM course;
```

## H2 Schema

H2 will automatically pick up the `schema.sql` file that we provided and will generate the tables.

### Manually inserting data

From the H2 console run the below query in insert some data.

```sql
INSERT INTO course (name, author) VALUES ('JS', 'John');
```

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Data JPA
  - Spring Data JDBC
  - Lombok
  - H2 Database
