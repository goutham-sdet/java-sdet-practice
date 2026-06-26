FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B test -Dtest="api.*"