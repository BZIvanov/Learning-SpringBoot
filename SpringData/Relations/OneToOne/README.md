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

### Get data

**GET `http://localhost:8080/api/students/1`**

### Generated query

This will be the generated query by hibernate. We can view this in the console after sending the GET request.

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
