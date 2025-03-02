# OneToMany demo

## Playing with the demo

### Create data

**POST `http://localhost:8080/api/schools`**

```json
{
  "name": "Spring Boot Academy",
  "location": "New York",
  "students": [
    {
      "name": "Alice Johnson",
      "email": "alice@example.com"
    },
    {
      "name": "Bob Smith",
      "email": "bob@example.com"
    }
  ]
}
```

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    insert
    into
        school
        (location, name)
    values
        (?, ?)
Hibernate:
    insert
    into
        student
        (email, name, school_id)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        student
        (email, name, school_id)
    values
        (?, ?, ?)
```

Response:

```json
{
  "id": 1,
  "name": "Spring Boot Academy",
  "location": "New York",
  "students": [
    {
      "id": 1,
      "name": "Alice Johnson",
      "email": "alice@example.com"
    },
    {
      "id": 2,
      "name": "Bob Smith",
      "email": "bob@example.com"
    }
  ]
}
```

### Get data

**GET `http://localhost:8080/api/schools/1`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.location,
        s1_0.name
    from
        school s1_0
    where
        s1_0.id=?
Hibernate:
    select
        s1_0.school_id,
        s1_0.id,
        s1_0.email,
        s1_0.name
    from
        student s1_0
    where
        s1_0.school_id=?
```

Response:

```json
{
  "id": 1,
  "name": "Spring Boot Academy",
  "location": "New York",
  "students": [
    {
      "id": 1,
      "name": "Alice Johnson",
      "email": "alice@example.com"
    },
    {
      "id": 2,
      "name": "Bob Smith",
      "email": "bob@example.com"
    }
  ]
}
```

### Delete data

**DELETE `http://localhost:8080/api/schools/1`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.location,
        s1_0.name
    from
        school s1_0
    where
        s1_0.id=?
Hibernate:
    select
        s1_0.school_id,
        s1_0.id,
        s1_0.email,
        s1_0.name
    from
        student s1_0
    where
        s1_0.school_id=?
Hibernate:
    delete
    from
        student
    where
        id=?
Hibernate:
    delete
    from
        student
    where
        id=?
Hibernate:
    delete
    from
        school
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
