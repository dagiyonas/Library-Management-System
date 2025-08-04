# Smart Library Access and Book Management System (CLI)

## Overview

A Java CLI application for managing library operations, including member management, book borrowing/returning, and librarian administration. The system implements robust OOP principles and follows modern software engineering practices.

## Features

- **User Management**
  - Add/remove library members
  - Add/remove librarians with shift information
  - Authorization management for both members and librarians

- **Book Operations**
  - Borrow/return books with proper validation
  - Track borrowed books by member
  - View book availability status

- **System Management**
  - SQLite database integration for persistent storage
  - File-based logging system
  - Exception handling and error recovery
  - Menu-driven CLI interface

## Technical Requirements

- Java 17 or higher
- SQLite JDBC driver (`sqlite-jdbc-3.42.0.0.jar`)
- Maven or Gradle for dependency management (recommended)

## Setup Instructions

### Prerequisites

1. Install Java 17 or higher
2. Download SQLite JDBC driver
3. Set up IDE (IntelliJ IDEA or VSCode recommended)

### Database Setup

1. Create a new SQLite database:
```sql
-- Run this in DB Browser for SQLite
CREATE DATABASE library;
```

2. Execute the schema:
```sql
-- Run library_schema.sql to create tables
```

### Running the Application

1. **Using IDE**:
   - Open project in IntelliJ IDEA or VSCode
   - Add SQLite JDBC driver to project dependencies
   - Run `ui.MainApp` as Java Application

2. **Using Command Line**:
```bash
# Compile
javac -cp sqlite-jdbc-3.42.0.0.jar ui/MainApp.java

# Run
java -cp sqlite-jdbc-3.42.0.0.jar:. ui.MainApp
```

## Technical Architecture

### Project Structure

```
├── model/           # Domain models
│   ├── LibraryUser.java    # Abstract base class
│   ├── Member.java         # Member implementation
│   └── Librarian.java      # Librarian implementation
│
├── interfaces/      # Core interfaces
│   ├── Borrowable.java     # Book borrowing interface
│   ├── Returnable.java     # Book returning interface
│   └── Authenticator.java  # Authentication interface
│
├── dao/            # Data Access Objects
│   ├── MemberDAO.java      # Member database operations
│   └── LibrarianDAO.java   # Librarian database operations
│
├── service/        # Business logic
│   └── LibrarySystem.java  # Main service layer
│
├── ui/            # User interface
│   └── MainApp.java        # CLI implementation
│
├── util/          # Utility classes
│   ├── DBConnectionUtil.java  # Database connection management
│   └── LoggerUtil.java        # Logging implementation
│
└── exceptions/    # Custom exceptions
    └── InvalidLibraryUserException.java
```

### Core Interfaces

- `Borrowable`: Defines book borrowing operations
- `Returnable`: Defines book returning operations
- `Authenticator`: Handles user authentication
- `ResourceManager`: Manages system resources
- `Notification`: Handles system notifications

## Usage Examples

### Adding a Member
```java
// Example from MainApp.java
System.out.print("Enter Member ID: ");
String id = scanner.nextLine();
System.out.print("Enter Section: ");
String section = scanner.nextLine();
Member member = new Member(id, section, true);
system.addMember(member);
```

### Adding a Librarian
```java
// Example from MainApp.java
System.out.print("Enter Librarian ID: ");
String id = scanner.nextLine();
System.out.print("Enter Section: ");
String section = scanner.nextLine();
System.out.print("Enter Shift: ");
String shift = scanner.nextLine();
Librarian librarian = new Librarian(id, section, true, shift);
system.addLibrarian(librarian);
```

## Error Handling

The system implements comprehensive error handling through:

1. Custom Exceptions
   - `InvalidLibraryUserException`: For invalid user data
   - `BookNotFoundException`: For unavailable books
   - `OperationNotAllowedException`: For unauthorized operations

2. Database Error Handling
   - Connection failure management
   - Transaction rollback on errors
   - Resource cleanup using try-with-resources

3. Input Validation
   - Null checks
   - Format validation
   - Authorization verification

## Logging System

The logging system provides:

1. **Log Levels**
   - INFO: General operations
   - ERROR: Error conditions
   - DEBUG: Detailed debugging information

2. **Log Format**
```
[timestamp] [level] [message]
```

3. **Log Storage**
   - Persistent storage in `library_log.txt`
   - Automatic timestamping
   - Error recovery logging

## Acknowledgments

- SQLite for database management
- Java JDBC for database connectivity
- Various open-source libraries used
