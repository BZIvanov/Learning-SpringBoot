# Relationships

## Unidirectional vs. Bidirectional relationships

- **Unidirectional** = Only one entity knows about the relationship.
- **Bidirectional** = Both entities know about each other and can access each other.

### @OneToOne

#### Unidirectional @OneToOne

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

#### Bidirectional @OneToOne

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

##### Which one should you use?

| **Use Case**                     | **Unidirectional `@OneToOne`** | **Bidirectional `@OneToOne`** |
| -------------------------------- | ------------------------------ | ----------------------------- |
| **Only one entity needs access** | ✅ Yes                         | ❌ No                         |
| **Both entities need access**    | ❌ No                          | ✅ Yes                        |
| **Simpler code**                 | ✅ Yes                         | ❌ No                         |
| **Avoiding infinite loops**      | ✅ Yes (No loops)              | ❌ No (Fix with DTOs)         |
| **Performance concern?**         | ✅ Better for large-scale apps | ❌ Can create extra queries   |

### @ManyToMany

#### Unidirectional @ManyToMany

- One entity knows about the relationship, but the other does not.
- Only one table has a reference to the other.
- A join table is still required.

```java
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}

@Entity
public class Course {
    @Id @GeneratedValue
    private Long id;
    private String title;
}
```

#### Bidirectional @ManyToMany

- Both entities know about each other.
- Both tables contain references.
- The relationship is managed on one side using mappedBy.

```java
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}

@Entity
public class Course {
    @Id @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "courses") // Reference the field in Student
    private List<Student> students = new ArrayList<>();
}
```

##### Which one should you use?

| **Type**           | **Description**                                                   | **When to Use**                                                                                                                 |
| ------------------ | ----------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| **Unidirectional** | Only one entity knows about the relationship. The other does not. | Use when the relationship is not needed on both sides (e.g., Student knows Courses, but Course doesn't need to track Students). |
| **Bidirectional**  | Both entities know about the relationship.                        | Use when you need navigation in both directions (e.g., finding all Students in a Course).                                       |

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
