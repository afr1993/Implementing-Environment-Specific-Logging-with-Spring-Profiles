# Spring Boot Profiles & Logging Example

This project demonstrates how to configure multiple Spring Boot profiles (`dev`, `test`, `prod`) and set up logging with Logback.

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Postman (optional, for testing APIs)

---

### 🔧 Setup

1. Clone the repository:

```bash
https://github.com/afr1993/Implementing-Environment-Specific-Logging-with-Spring-Profiles.git
cd springboot-profiles-logging

Run with a specific profile:
# dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# test profile
mvn spring-boot:run -Dspring-boot.run.profiles=test

# prod profile
mvn spring-boot:run -Dspring-boot.run.profiles=prod

🧪 API Endpoints
Get Active Profile
h
Copiar
Editar
GET /api/profiles
📌 Response:

json
Copiar
Editar
{
  "activeProfile": "dev"
}
You may need authentication depending on your configuration.

🔐 Authentication (If enabled)
Use HTTP Basic Auth:

makefile
Copiar
Editar
Username: admin
Password: admin123
Or modify /src/main/resources/application.properties accordingly.

📒 Profile-based Logging
The project uses logback-spring.xml to control logging behavior:

Profile	Logging Level	Output Destination
dev	DEBUG & INFO	Console
test	INFO only	Console
prod	WARN & ERROR	File (logs/app.log)

Logback uses the placeholder ${spring.profiles.active} to load the proper configuration dynamically.

📂 Logs (Production)
In prod profile, logs are stored in the logs/ folder as app.log. Make sure the folder exists or is created at runtime.


