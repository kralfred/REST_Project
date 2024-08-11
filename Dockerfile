# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /rest_project

# Copy the application JAR file into the container
COPY build/libs/REST_Project-0.0.1-SNAPSHOT.jar /rest_project/rest_project.jar

COPY . .
# Expose the port on which your application will run
EXPOSE 8050

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/rest_project/rest_project.jar"]
