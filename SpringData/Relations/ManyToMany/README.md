# ManyToMany demo

## Playing with the demo

### Create data

#### Create courses

**POST `http://localhost:8080/api/courses`**

```json
{
  "title": "Math 101",
  "description": "Basic Algebra"
}
```

```json
{
  "title": "History 101",
  "description": "World History"
}
```

```json
{
  "title": "Physics 101",
  "description": "Basic Physics"
}
```

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    insert
    into
        course
        (description, title)
    values
        (?, ?)
```

Response:

```json
{
  "id": 1,
  "title": "Math 101",
  "description": "Basic Algebra",
  "students": []
}
```

#### Create students

**POST `http://localhost:8080/api/students`**

```json
{
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "courses": [{ "id": 1 }, { "id": 2 }]
}
```

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        c1_0.id,
        c1_0.description,
        c1_0.title
    from
        course c1_0
    where
        c1_0.id=?
Hibernate:
    select
        c1_0.id,
        c1_0.description,
        c1_0.title
    from
        course c1_0
    where
        c1_0.id=?
Hibernate:
    insert
    into
        student
        (email, name)
    values
        (?, ?)
Hibernate:
    insert
    into
        student_courses
        (student_id, course_id)
    values
        (?, ?)
Hibernate:
    insert
    into
        student_courses
        (student_id, course_id)
    values
        (?, ?)
```

Response:

```json
{
  "id": 1,
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "courses": [
    {
      "id": 1,
      "title": "Math 101",
      "description": "Basic Algebra"
    },
    {
      "id": 2,
      "title": "History 101",
      "description": "World History"
    }
  ]
}
```

### Get data

**GET `http://localhost:8080/api/students/1`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.email,
        s1_0.name
    from
        student s1_0
    where
        s1_0.id=?
Hibernate:
    select
        c1_0.student_id,
        c1_1.id,
        c1_1.description,
        c1_1.title
    from
        student_courses c1_0
    join
        course c1_1
            on c1_1.id=c1_0.course_id
    where
        c1_0.student_id=?
```

Response:

```json
{
  "id": 1,
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "courses": [
    {
      "id": 1,
      "title": "Math 101",
      "description": "Basic Algebra"
    },
    {
      "id": 2,
      "title": "History 101",
      "description": "World History"
    }
  ]
}
```

### Enroll student in a course

**POST `http://localhost:8080/api/students/1/enroll/3`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.email,
        s1_0.name
    from
        student s1_0
    where
        s1_0.id=?
Hibernate:
    select
        c1_0.id,
        c1_0.description,
        c1_0.title
    from
        course c1_0
    where
        c1_0.id=?
Hibernate:
    select
        c1_0.student_id,
        c1_1.id,
        c1_1.description,
        c1_1.title
    from
        student_courses c1_0
    join
        course c1_1
            on c1_1.id=c1_0.course_id
    where
        c1_0.student_id=?
Hibernate:
    delete
    from
        student_courses
    where
        student_id=?
Hibernate:
    insert
    into
        student_courses
        (student_id, course_id)
    values
        (?, ?)
Hibernate:
    insert
    into
        student_courses
        (student_id, course_id)
    values
        (?, ?)
Hibernate:
    insert
    into
        student_courses
        (student_id, course_id)
    values
        (?, ?)
```

Response:

```json
{
  "id": 1,
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "courses": [
    {
      "id": 1,
      "title": "Math 101",
      "description": "Basic Algebra"
    },
    {
      "id": 2,
      "title": "History 101",
      "description": "World History"
    },
    {
      "id": 3,
      "title": "Physics 101",
      "description": "Basic Physics"
    }
  ]
}
```

### Delete data

**DELETE `http://localhost:8080/api/students/1`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.email,
        s1_0.name
    from
        student s1_0
    where
        s1_0.id=?
Hibernate:
    delete
    from
        student_courses
    where
        student_id=?
Hibernate:
    delete
    from
        student
    where
        id=?
```

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Lombok
