# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . /app

ENTRYPOINT ["java", "-jar", "out/artifacts/REST_Project_jar/REST_Project.jar"]

EXPOSE 8050
