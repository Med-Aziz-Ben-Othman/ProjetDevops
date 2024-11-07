FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY target/DevOps_Project-1.2.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


