# Step 1: Use OpenJDK 8 as base image
FROM openjdk:8-jdk-slim

# Step 2: Set working directory inside container
WORKDIR /maindirectory

# Step 3: Copy JAR from Gradle build output to container
COPY build/libs/*.jar vy-dental-care.jar

# Step 4: Expose port (Spring Boot default: 8080)
EXPOSE 8083

# Step 5: Run the JAR
ENTRYPOINT ["java", "-jar", "vy-dental-care.jar"]
