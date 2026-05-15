# Multi-stage Dockerfile for Football Standing Table Calculator

# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY checkstyle.xml .
COPY checkstyle-suppressions.xml .

RUN mvn clean package

# Stage 2: Runtime
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/standing-table-calculator-jar-with-dependencies.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
