# Use an official OpenJDK runtime as a parent image
FROM  openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY target/zenbreeder.jar /app/zenbreeder.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "zenbreeder.jar"]
