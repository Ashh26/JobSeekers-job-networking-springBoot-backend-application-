FROM maven:3.9.4-eclipse-temurin-21-alpine

WORKDIR /app

# Copy Maven wrapper files and pom.xml
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Make mvnw executable and download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Expose port
EXPOSE 8080

# Run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]