# TaskFlow Backend

TaskFlow is a collaborative task management platform designed to address the shortcomings of existing task management tools. The project is driven by a commitment to innovation, utilizing Spring Boot for the backend. TaskFlow aims to simplify task management complexities for individuals, team leaders, and managers in dynamic work environments.

## Functionalities for Version 1.0.0

### CRUD Operations for Tasks
- Implement CRUD operations for tasks in the backend using Spring Data JPA.
- Ensure tasks cannot be created in the past.
- Require users to enter multiple tags for tasks.
- Restrict task scheduling to 3 days in advance.
- Enforce marking a task as completed before the deadline.
- Allow users to assign additional tasks to themselves, not to others.
- Provide 2 tokens per day to replace tasks assigned by the manager.
- Allow 1 token per month for task deletion.
- Deleting a task created by the same user does not affect tokens.

### Deployment
After implementing the above functionalities, deploy the application to your local repository.

## Functionalities for Version 1.1.0

1. When the manager replaces a task, they must assign it to another user, and this task cannot be modified or deleted using tokens.
2. If the manager does not respond to a task change request within 12 hours, the user gains a double token modification balance the next day.
3. Every 24 hours, mark tasks as incomplete if they are not marked as completed and have exceeded the deadline.
4. Allow managers to view an overview of all tasks assigned to their employees. Include a completion percentage filtered by tags for the week, month, and year. Also, display the number of tokens used.

### Deployment
After implementing the new functionalities, deploy the application to your local repository.

## Technical Requirements

1. Implement global exception handling.
2. Use native queries for specific database operations.
3. Create DTOs for data transfer between layers and use MapStruct.
4. Integrate SonarQube for static code analysis to ensure code quality.
5. Write unit tests using JUnit and Mockito for critical components.
6. Use Liquibase for database schema management.
7. Implement authentication and authorization using Spring Security.

## Technologies Used

- **Spring Boot:** Backend framework
- **Spring Data JPA:** Data access framework
- **Spring Security:** Authentication and authorization
- **Hibernate:** Object-relational mapping (ORM)
- **Maven:** Build and dependency management

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- PostgreSQL database

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/mouad5-bot/task_managment.git
   cd task_managment

2. Build and run the Spring Boot application
  ```bash
    ./mvnw spring-boot:run


