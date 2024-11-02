# Multi-stage build for efficiency

# First stage: Build the application with Maven
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean install -DskipTests

# Second stage: Use OpenJDK 17 for running the application
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/DevOps_Project-1.0.jar /app/DevOps_Project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/DevOps_Project.jar"]
