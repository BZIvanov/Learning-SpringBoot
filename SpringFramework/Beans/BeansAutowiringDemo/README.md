# Beans autowiring demo

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web

## What is @Autowired and why we need it?

Spring is **not asking for** `@Autowired` because of `Subject` (from this demo) itself. Instead, it’s asking because:

✅ Spring creates the Teacher object (since it’s a @Component or @Bean).
✅ Spring must decide which constructor to use when there are multiple options.
✅ If there’s only one constructor, Spring automatically picks it.
✅ If there are multiple constructors, Spring needs help, that’s when `@Autowired` is required!

So `@Autowired` is about constructor selection, not dependency selection.

In this demo, we have only 1 constructor so we could skip @Autowired, because in case we had more than 1 constructor, we must annotate the constructor we want.
