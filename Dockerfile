# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11-slim AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:11-jre-slim
# Set the working directory in the container
WORKDIR /app
EXPOSE 8080
# Copy the built JAR file from the previous stage to the container
COPY /target/docker-java-app-example.jar /app
# Set the command to run the application
CMD ["java", "-jar", "docker-java-app-example.jar"]
# Use an official OpenJDK runtime as a parent image
# FROM openjdk:8-jre-alpine

# # Install Maven
# RUN apk add --no-cache curl tar bash && \
#     curl -fsSL -o /tmp/apache-maven.tar.gz https://downloads.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz && \
#     tar -xzf /tmp/apache-maven.tar.gz -C /opt && \
#     ln -s /opt/apache-maven-3.8.4 /opt/maven && \
#     ln -s /opt/maven/bin/mvn /usr/bin/mvn && \
#     rm -f /tmp/apache-maven.tar.gz



# # Set the working directory to /app
# WORKDIR /app

# # Copy the Maven project's files into the container at /app
# COPY . /app

# # Run Maven clean install
# RUN mvn clean install

# # Copy the fat jar into the container at /app
# COPY /target/docker-java-app-example.jar /app

# # Make port 8080 available to the world outside this container
# EXPOSE 8080

# # Run jar file when the container launches
# CMD ["java", "-jar", "docker-java-app-example.jar"]
