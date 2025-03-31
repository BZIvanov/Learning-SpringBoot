# MapStruct

**MapStruct** is a **Java annotation processor** that automatically generates efficient, type-safe mapping code to convert between Java objects (DTOs, Entities, etc.).

MapStruct is a must-have for large applications where DTO-Entity conversions are frequent. It reduces boilerplate, improves performance, and prevents errors.

## Why do we need MapStruct?

In Spring Boot applications, we often need to convert data between:

- Entity ↔ DTO (Data Transfer Object)
- DTO ↔ Response Model
- Domain Object ↔ View Model

Manually writing mapping code (like convertToDTO and convertToEntity methods) is error-prone, repetitive, and time-consuming. MapStruct automates this process.

## Problems MapStruct Solves

- **Removes Boilerplate Code** → No need for manual getters/setters copying.
- **Faster Performance** → Generates direct getter/setter calls, unlike reflection-based libraries (like ModelMapper).
- **Type Safety** → Compile-time type checking ensures correct mappings.
- **Custom Mappings** → Allows customization using @Mapping.
- **Avoids Performance Overhead** → Unlike reflection-based mappers (e.g., Dozer, ModelMapper), MapStruct generates static code at compile time, making it highly efficient.

## When should you use MapStruct?

| ✅ Use MapStruct When...                  | ❌ Don't Use MapStruct When...                                                    |
| ----------------------------------------- | --------------------------------------------------------------------------------- |
| You want automatic, type-safe mapping     | You only need one or two mappings (manual conversion is fine)                     |
| You need high performance (no reflection) | You prefer reflection-based solutions like ModelMapper (flexible but slower)      |
| You work with DTOs, APIs, microservices   | You need complex mappings with dynamic logic (manual conversion is more flexible) |

## Content

Recommended learning order for this section:

1. BasicMapping
