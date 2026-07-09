# Task Management & Observability Service
A production-grade Task Management REST API developed as a technical assessment. This service combines robust CRUD operations with an automated, heuristic-based log analysis engine to demonstrate system observability and scalable architectural thinking.

# 🚀 Key Features
**Task Management:** Full RESTful API for task lifecycle management.

**Observability Engine:** Custom automated log analysis logic to detect system anomalies without relying on heavy LLM integrations.

**Production Ready:** Built with Spring Boot, featuring structured logging, global exception handling, and standardized DTO-based API contracts.

**Scalability Mindset:** Architected with horizontal scaling and CI/CD automation in mind.

# 🛠 Tech Stack
**Language/Framework:** Java 17+, Spring Boot 3.x

**Build Tool:** Maven/Gradle

**Data Persistence:** Spring Data JPA (H2/PostgreSQL)

**Testing:** JUnit 5, MockMvc

**Containerization:** Docker (Ready for deployment)

# 📋 Architecture Overview
The service follows a layered architecture (Controller -> Service -> Repository) to ensure separation of concerns and maintainability.

**API Layer:** Handles request validation and response mapping.

**Service Layer:** Contains business logic and the automated log analysis heuristics.

**Observability:** Custom service for real-time log pattern detection using regex-based outlier analysis.

# 🏗 Setup & Running
# Clone the repo:
git clone https://github.com/awp-1/qualcomm-technical-assignment.git

# Build the project:
./mvnw clean install

# Run the application:
./mvnw spring-boot:run

# 🧪 Testing
The project includes comprehensive unit tests covering API endpoints and service-level business logic.
./mvnw test

# 📁 Documentation
DESIGN.md - Deep dive into system design, scalability strategy, and architectural decisions.

AI_SKILL.md - Details on the log analysis engine design and rationale.
