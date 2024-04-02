# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/payment-service.jar /app/payment-service.jar

# Specify the command to run your application
CMD ["java", "-jar", "payment-service.jar"]
