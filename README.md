# Spring Boot Journal App

## Overview
Spring Boot Journal App is a RESTful API that allows users to create, update, delete, and retrieve journal entries. It uses **Spring Boot**, **MongoDB**, and **Spring Data MongoDB** to provide a simple backend for managing journal entries.

## Features
- Create a new journal entry
- Retrieve all journal entries
- Update an existing journal entry
- Delete a journal entry

## Technologies Used
- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven

## Installation and Setup
### Prerequisites
Make sure you have the following installed:
- Java 17 or later
- Maven
- MongoDB
- Git

### Clone the Repository
```bash
git clone https://github.com/KUSH072001/springboot-journal-app.git
cd springboot-journal-app
```

### Configure MongoDB
Ensure that MongoDB is running and update the database connection in `src/main/resources/application.properties`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/journalDB
```

### Build and Run the Application
```bash
mvn spring-boot:run
```

## API Endpoints
| Method | Endpoint         | Description |
|--------|----------------|-------------|
| GET    | `/get`         | Retrieve all journal entries |
| POST   | `/add`        | Add a new journal entry |
| PUT    | `/update/{id}` | Update an existing journal entry |
| DELETE | `/delete/{id}` | Delete a journal entry |

## Example JSON Request for Adding an Entry
```json
{
    "title": "My First Entry",
    "description": "Today was a great day!"
}
```

## Contributing
1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Make your changes and commit (`git commit -m "Added a new feature"`)
4. Push to the branch (`git push origin feature-branch`)
5. Open a Pull Request

## License
This project is licensed under the MIT License.

---
Feel free to contribute and enhance the project!

