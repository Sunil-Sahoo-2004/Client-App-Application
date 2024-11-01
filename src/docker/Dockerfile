# Use a Linux-based OpenJDK image
FROM openjdk:17-jdk-alpine

# Copy the Spring Boot application JAR file to the container
COPY src/build/libs/SpringServer-0.0.1-SNAPSHOT.jar /app/

# Set the working directory
WORKDIR /app

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "SpringServer-0.0.1-SNAPSHOT.jar"]
