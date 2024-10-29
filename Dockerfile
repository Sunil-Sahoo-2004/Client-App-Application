# Stage 1: Build the application using Gradle
FROM gradle:7.5.0-jdk17 AS build

# Copy the project files
COPY . /spring-server

# Set the working directory
WORKDIR /spring-server

# Grant execute permissions to the Gradle wrapper script
RUN chmod +x ./gradlew

# Build the project and package it as a JAR
RUN ./gradlew bootJar --no-daemon

# Stage 2: Create the final image to deploy the app
FROM openjdk:17-jdk-slim
EXPOSE 5000

# Copy the JAR file from the build stage
COPY --from=build /spring-server/build/libs/*.jar SpringServer.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "SpringServer.jar"]
