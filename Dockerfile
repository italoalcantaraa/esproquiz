# === Build stage ===
FROM maven:3.9.1-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# === Runtime stage ===
FROM eclipse-temurin:17-jre

WORKDIR /app
EXPOSE 8080

COPY --from=build /app/target/quiz-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
