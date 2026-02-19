# Step 1: Use Maven with Temurin JDK 21 for building the app
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /back-end

COPY back-end/pom.xml .
COPY back-end/src ./src

# Maven is pre-installed; no need to apt-get anything
RUN mvn clean package -DskipTests

# Step 2: Use Temurin JRE 17 for runtime
FROM eclipse-temurin:17.0.15_6-jre

WORKDIR /back-end

COPY --from=builder /back-end/target/back-end-0.0.1-SNAPSHOT.jar back-end.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "back-end.jar"]