# JPA CRUD demo

As continuation from the previous demo, in this demo we replaced all the boilerplate code with JPA repository and we can still use all the CRUD operations on the Student entity.

## MySQL setup

Check the previous demo on how to setup the database.

## Demo endpoints

- GET `http://localhost:8080/api/students`
- GET `http://localhost:8080/api/students/1`
- POST `http://localhost:8080/api/students`
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@mail.com"
  }
  ```
- PUT `http://localhost:8080/api/students/1`
  ```json
  {
    "firstName": "Jake",
    "lastName": "Doe",
    "email": "jake@mail.com"
  }
  ```
- DELETE `http://localhost:8080/api/students/1`

## Advantages of JpaRepository Over EntityManager

| Feature                    | `JpaRepository` (Spring Data JPA)                 | `EntityManager` (Manual JPA)                 |
| -------------------------- | ------------------------------------------------- | -------------------------------------------- |
| **Less Code**              | ✅ **No need to write queries**                   | ❌ Manual queries needed                     |
| **Built-in CRUD**          | ✅ **Auto-generated methods**                     | ❌ Need to write `persist()`, `find()`, etc. |
| **Pagination & Sorting**   | ✅ **Easy with `findAll(Pageable)`**              | ❌ Manual implementation needed              |
| **Custom Queries**         | ✅ `@Query` or method names (`findByFirstName()`) | ❌ Need to use JPQL or Criteria API          |
| **Better Maintainability** | ✅ **Less boilerplate code**                      | ❌ More code to maintain                     |

## Custom rest repository resource name

```java
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// here is how to provide custom name to be used in the endpoint
// by default, it will be pluralized to employees anyway, but this is just for example
@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
```
