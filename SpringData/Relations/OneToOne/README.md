# OneToOne demo

## Playing with the demo

### Create data

**POST `http://localhost:8080/api/students`**

```json
{
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "studentProfile": {
    "address": "456 School St",
    "phoneNumber": "987-654-3210"
  }
}
```

Hibernate generated queries (we can see it in the projects console):

```
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
        student_profile
        (address, phone_number, student_id)
    values
        (?, ?, ?)
```

### Get data

**GET `http://localhost:8080/api/students/1`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.email,
        s1_0.name,
        sp1_0.id,
        sp1_0.address,
        sp1_0.phone_number,
        sp1_0.student_id
    from
        student s1_0
    left join
        student_profile sp1_0
            on s1_0.id=sp1_0.student_id
    where
        s1_0.id=?
```

### Delete data

**DELETE `http://localhost:8080/api/students/1`**

Hibernate generated queries (we can see it in the projects console):

```
Hibernate:
    select
        s1_0.id,
        s1_0.email,
        s1_0.name,
        sp1_0.id,
        sp1_0.address,
        sp1_0.phone_number,
        sp1_0.student_id
    from
        student s1_0
    left join
        student_profile sp1_0
            on s1_0.id=sp1_0.student_id
    where
        s1_0.id=?
Hibernate:
    delete
    from
        student_profile
    where
        id=?
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
