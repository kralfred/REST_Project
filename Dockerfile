# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine


# Copy the JAR file to the container
COPY out/artifacts/REST_Project_jar/REST_Project.jar /REST_Project.jar



# Run the JAR file
ENTRYPOINT ["java", "-jar", "REST_Project.jar"]


EXPOSE 8050