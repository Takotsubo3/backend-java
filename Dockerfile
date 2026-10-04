FROM maven:3.9.16-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


FROM openjdk:17.0.2-jdk AS lancement

WORKDIR /app-lancement

COPY --from=build /app/target/*.jar ./application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]