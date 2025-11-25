# Library Management System

A **Java-based GUI application** for managing a library, developed as part of Review 1 requirements. The system uses **SQLite** for database management and provides a user-friendly interface for library operations.

---

## **Features**

- **Book Management**
  - Add, update, delete, and view books.
  - Validation and exception handling for incorrect entries.

- **User Management**
  - Abstract user structure with student and admin roles.
  - Display user information and roles.

- **Database Integration**
  - Uses **SQLite** (`library.db`) to store book and user data.
  - Automatic database creation on first run if not present.

- **GUI Interface**
  - Developed with **Java Swing**.
  - Interactive windows for book and user operations.

- **Exception Handling**
  - Custom exceptions like `InvalidBookException` for validation.
  - Ensures stable execution
  
