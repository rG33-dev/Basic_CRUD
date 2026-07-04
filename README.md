# 🚀 Beginner Backend Project

A simple backend project built for learning backend development using Spring Boot, Kotlin, and a bit of Java.

This project demonstrates basic CRUD operations for fetching and storing data in a MySQL database. DBeaver is used for database visualization and management.

---

## 🛠️ Tech Stack

<p align="left">
  <img src="https://skillicons.dev/icons?i=spring,kotlin,java,mysql" />
  <img src="https://cdn.simpleicons.org/dbeaver" alt="DBeaver" height="48"/>
</p>

---

## ✨ Features

- 📦 Basic CRUD operations
- 🌱 Beginner-friendly Spring Boot project
- 💾 MySQL database integration
- 🔄 REST API endpoints
- ⚡ Built primarily with Kotlin and a small amount of Java
- 🗄️ Database visualization using DBeaver

---

## 📋 Prerequisites

Before running the project, make sure you have:

- Java 17+
- MySQL Server
- Gradle or Maven
- IntelliJ IDEA (Recommended)
- DBeaver (Optional)

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repository.git
```

### 2. Create a MySQL database

```sql
CREATE DATABASE your_database_name;
```

### 3. Configure the database

Update your `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Run the project

```bash
./gradlew bootRun
```

or

```bash
./mvnw spring-boot:run
```

---

## 🎯 Learning Goals

This project is built to understand:

- REST APIs
- Spring Boot fundamentals
- Kotlin backend development
- Java interoperability
- Database integration
- CRUD operations
- Clean project structure

---

## 🔮 Future Plans

- 📱 Build a mobile application using this backend
- 🔐 User authentication
- 📄 API documentation (Swagger/OpenAPI)
- ✅ Unit & Integration Tests
- 🐳 Docker support
- ☁️ Cloud deployment

---

## 📁 Project Structure

```
src
├── main
│   ├── kotlin
│   ├── java
│   └── resources
└── test
```

---

## 🤝 Contributing

This is a personal learning project, but suggestions and improvements are always welcome.

---

## 📜 License

This project is available for learning, experimentation, and personal use.

---

<p align="center">
Made with ❤️ while learning Backend Development
</p>
