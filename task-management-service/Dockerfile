# ==========================================
# Stage 1: Build the Application
# ==========================================
FROM eclipse-temurin:21-jdk-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml first to cache dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies (this layer will be cached unless pom.xml changes)
RUN ./mvnw dependency:go-offline

# Copy the actual source code and build the application
COPY src ./src
RUN ./mvnw clean package -DskipTests

# ==========================================
# Stage 2: Create the Production Image
# ==========================================
# Notice we use 'jre' (Java Runtime Environment) instead of 'jdk', which makes the image much smaller
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy ONLY the built .jar file from the 'builder' stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]