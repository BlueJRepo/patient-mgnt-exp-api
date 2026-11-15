#FROM openjdk:21 //Deprecated from Docker
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY ./target/patient-mgnt-exp-api-0.0.1.jar /app
EXPOSE 8080
CMD ["java", "-jar", "patient-mgnt-exp-api-0.0.1.jar"]