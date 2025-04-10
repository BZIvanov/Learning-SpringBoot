# Blog Project

This is a demo project.

## API endpoints

### Authentication

- POST `http://localhost:8080/api/auth/login` - login user
  ```json
  {
    "email": "user@test.com",
    "password": "password"
  }
  ```

### Categories

- GET `http://localhost:8080/api/categories` - get list of categories
- POST `http://localhost:8080/api/categories` - create category
  ```makefile
  Authorization: Bearer jwt-token-here
  ```
  ```json
  {
    "name": "Hello"
  }
  ```
- DELETE `http://localhost:8080/api/categories/{categoryId}` - delete category
  ```makefile
  Authorization: Bearer <jwt-token>
  ```

### Tags

- GET `http://localhost:8080/api/tags` - get list of tags
- POST `http://localhost:8080/api/tags` - create tag
  ```makefile
  Authorization: Bearer jwt-token-here
  ```
  ```json
  {
    "names": ["first", "second", "third"]
  }
  ```
- DELETE `http://localhost:8080/api/tags/{tagId}` - delete tag
  ```makefile
  Authorization: Bearer <jwt-token>
  ```

### Posts

- GET `http://localhost:8080/api/posts` - get list of published posts
- GET `http://localhost:8080/api/posts/drafts` - get list of draft posts
  ```makefile
  Authorization: Bearer <jwt-token>
  ```
- GET `http://localhost:8080/api/posts/{postId}` - get post by id
- POST `http://localhost:8080/api/posts` - create post
  ```makefile
  Authorization: Bearer jwt-token-here
  ```
  ```json
  {
    "title": "Test post title",
    "content": "This is my new post here. Enjoy reading it.",
    "categoryId": "bb1b31d2-9b85-4840-904f-39123d710a12",
    "tagIds": [
      "e744b94b-4c7c-49a3-bd23-75fe3facca50",
      "94f6dc18-290b-4e78-9ab4-6ebd806d86bc"
    ],
    "status": "DRAFT"
  }
  ```
- PUT `http://localhost:8080/api/posts/{postId}` - update post by id
  ```makefile
  Authorization: Bearer jwt-token-here
  ```
  ```json
  {
    "id": "16ddfdf4-acc6-41b2-b0cd-7c2d05346ec7",
    "title": "Test post title2",
    "content": "This is my new post here2. Enjoy reading it.2",
    "categoryId": "bb1b31d2-9b85-4840-904f-39123d710a12",
    "tagIds": [
      "e744b94b-4c7c-49a3-bd23-75fe3facca50",
      "94f6dc18-290b-4e78-9ab4-6ebd806d86bc"
    ],
    "status": "DRAFT"
  }
  ```
- DELETE `http://localhost:8080/api/posts/{postId}` - delete post by id
  ```makefile
  Authorization: Bearer <jwt-token>
  ```
