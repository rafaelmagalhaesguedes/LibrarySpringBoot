# Alexandria Library Management System

Alexandria is a library management system that allows users to manage books, authors, and publishers. This system provides RESTful APIs to perform CRUD (Create, Read, Update, Delete) operations on books, authors, and publishers.

## Features

- Manage books with detailed information.
- Manage authors and link them to books.
- Manage publishers and assign them to books.
- RESTful API architecture for easy integration.

## Installation

1. Clone the repository:
```
git clone https://github.com/yourusername/alexandria.git
cd alexandria
```

2. Build the project:
```
./mvnw clean install
```

3. Run the application:
```
./mvnw spring-boot:run
```

4. Access the application:
```
The application will be accessible at http://localhost:8080.
```

## Usage
To interact with the system, you can use tools like curl, Postman, or any other API client to send HTTP requests to the endpoints described below.

## API Endpoints

### Books

- Get all books:
    ```
    GET /books
    ```

- Get book by ID:
    ```
    GET /books/{id}
    ```

- Create a new book:
    ```
    POST /books
    ```

- Update book:
    ```
    PUT /books/{id}
    ```
  
- Delete book:
    ```
    DELETE /books/{id}
    ```

- Add a book detail:
    ```
    POST /books/{bookId}/detail
    ```

- Get book detail:
    ```
    GET /books/{bookId}/detail
    ```

- Update book detail:
    ```
    PUT /books/{bookId}/detail
    ```

- Remove book detail:
    ```
    DELETE /books/{bookId}/detail
    ```

- Set book publisher:
    ```
    PUT /books/{bookId}/publisher/{publisherId}
    ```

- Remove book publisher:
    ```
    DELETE /books/{bookId}/publisher
    ```

- Add book author:
    ```
    POST /books/{bookId}/authors/{authorId}
    ```

- Remove book author:
    ```
    DELETE /books/{bookId}/authors/{authorId}
    ```

### Author

- Get all authors:
    ```
    GET /authors
    ```

- Get author by ID:
    ```
    GET /authors/{id}
    ```

- Create a new author:
    ```
    POST /authors
    ```

- Update author:
    ```
    PUT /authors/{id}
    ```

- Delete author:
    ```
    DELETE /authors/{id}
    ```

### Publishers

- Get all publishers:
    ```
    GET /publishers
    ```

- Get publisher by ID:
    ```
    GET /publishers/{id}
    ```

- Create a new publisher:
    ```
    POST /publishers
    ```

- Update publisher:
    ```
    PUT /publishers/{id}
    ```

- Delete publisher:
    ```
    DELETE /publishers/{id}
    ```