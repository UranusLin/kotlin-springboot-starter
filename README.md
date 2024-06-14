# Kotlin Spring Boot Starter

This repository serves as a starter template for building applications with Kotlin and Spring Boot. It provides a basic structure and setup, including database migration with Flyway, Docker configuration, and a sample API for managing user data.
## Features

- **Kotlin and Spring Boot**: Leverage the powerful combination of Kotlin and Spring Boot for building robust and maintainable applications.
- **Flyway**: Integrated database migration management to handle schema changes effortlessly.
- **PostgreSQL**: Pre-configured PostgreSQL database for development and production environments.
- **Docker**: Docker and Docker Compose configurations for containerized development and deployment.
- **Gradle**: Gradle build system for dependency management and build automation.
- **Sample** API: Includes a sample API for user management with basic CRUD operations.
- **Testing**: Configured for testing with JUnit 5 and MockMvc.

## Getting Started

### Prerequisites

- [JDK 21](https://jdk.java.net/)
- [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/)

### Running the Application

1. **Clone the repository**:
   ```sh
   git clone https://github.com/UranusLin/kotlin-springboot-starter.git
   cd kotlin-springboot-starter
   ```

2. **Build the application**:
   ```sh
   make build
   ```
   
3. **Run the application**:
   ```sh
   make run
   ```

4. **Run with Docker**:
   ```sh
   make docker-up
   ```

5. **ktlintCheck**:
   ```sh
   make llint
   ```

6. **ktlintFormat**:
   ```sh
   make format
   ```

7. **Run Tests**:
   ```sh
   make test
   ```
   
### Project Structure
```css
kotlin-springboot-starter/
├── build.gradle.kts
├── docker-compose.yml
├── Dockerfile
├── Makefile
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   └── com/
│   │   │       └── starter/
│   │   │           ├── controller/
│   │   │           │   └── UserController.kt
│   │   │           ├── service/
│   │   │           │   └── UserService.kt
│   │   │           ├── repository/
│   │   │           │   └── UserRepository.kt
│   │   │           ├── model/
│   │   │           │   └── User.kt
│   │   │           ├── dto/
│   │   │           │   └── UserDto.kt
│   │   │           ├── config/
│   │   │           │   └── SecurityConfig.kt
│   │   │           └── KotlinSpringbootStarterApplication.kt
│   │   ├── resources/
│   │       ├── db/
│   │       │   └── migration/
│   │       │       └── V1__Initial_schema.sql
│   │       ├── static/
│   │       ├── templates/
│   │       ├── application.yml
│   │       └── application-dev.yml
│   └── test/
│       ├── kotlin/
│       │   └── com/
│       │       └── starter/
│       │           └── UserControllerTest.kt
│       └── resources/
│           └── application-test.yml
└── README.md
```

### Configuration
#### application.yml
```yaml
spring:
  datasource:
    url: jdbc:postgresql://db:5432/gym_management
    username: your_db_username
    password: your_db_password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
```

### Docker Compose
#### docker-compose.yml
```yaml
version: '3.8'

services:
  app:
    image: kotlin-springboot-starter
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/springboot-starter
      SPRING_DATASOURCE_USERNAME: your_db_username
      SPRING_DATASOURCE_PASSWORD: your_db_password
      SPRING_FLYWAY_ENABLED: true
      SPRING_FLYWAY_LOCATIONS: classpath:db/migration
      SPRING_FLYWAY_BASELINE_ON_MIGRATE: true

  db:
    image: postgres:13
    environment:
      POSTGRES_DB: springboot-starter
      POSTGRES_USER: your_db_username
      POSTGRES_PASSWORD: your_db_password
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
```

### Database Migration
This project uses Flyway for database migrations. Migration scripts are located in `src/main/resources/db/migration`.

#### Applying Migrations
To apply migrations, run:
```sh
make migrate
```

### Contributing
Contributions are welcome! Please feel free to submit a PR or open an issue.

### License
This project is licensed under the MIT License.

