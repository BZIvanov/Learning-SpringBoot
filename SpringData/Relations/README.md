# Relationships

## Unidirectional vs. Bidirectional relationships

- **Unidirectional** = Only one entity knows about the relationship.
- **Bidirectional** = Both entities know about each other and can access each other.

### Unidirectional @OneToOne

- Only one entity holds the reference
- No need to handle both sides of the relationship
- Simpler, but limits navigation

```java
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_profile_id")  // Foreign key in Student table
    private StudentProfile studentProfile;  // 👈 Only Student knows about StudentProfile
}

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String phoneNumber;
}
```

### Bidirectional @OneToOne

- Both entities hold a reference to each other
- Can navigate from Student → StudentProfile AND StudentProfile → Student
- More complex, but useful when data is accessed from both sides

```java
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;  // 👈 StudentProfile also knows Student
}

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "student_id")  // Foreign key in StudentProfile table
    private Student student;  // 👈 This makes it bidirectional
}
```

### Which one should you use?

| **Use Case**                     | **Unidirectional `@OneToOne`** | **Bidirectional `@OneToOne`** |
| -------------------------------- | ------------------------------ | ----------------------------- |
| **Only one entity needs access** | ✅ Yes                         | ❌ No                         |
| **Both entities need access**    | ❌ No                          | ✅ Yes                        |
| **Simpler code**                 | ✅ Yes                         | ❌ No                         |
| **Avoiding infinite loops**      | ✅ Yes (No loops)              | ❌ No (Fix with DTOs)         |
| **Performance concern?**         | ✅ Better for large-scale apps | ❌ Can create extra queries   |

## FetchType options

| **Fetch Type** | **Description**                                                      | **Default For**             |
| -------------- | -------------------------------------------------------------------- | --------------------------- |
| `EAGER`        | Loads the related entity immediately when the main entity is loaded. | `@OneToOne`, `@ManyToOne`   |
| `LAZY`         | Loads the related entity only when accessed (uses proxy).            | `@OneToMany`, `@ManyToMany` |

## Content

Recommended learning order for this section:

1. OneToOne
2. OneToMany
3. ManyToMany
4. EntityManagerRelations
