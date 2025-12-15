FROM maven:3.9.9-eclipse-temurin-17 AS builder
LABEL authors="Vishwa"
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk AS runner

WORKDIR /app
COPY --from=builder /app/target/gateway-service-0.0.1-SNAPSHOT.jar ./gateway-service.jar

EXPOSE 8222
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
