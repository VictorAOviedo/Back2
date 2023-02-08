FROM amazoncorretto:8-alpine-jdk
MAINTAINER VAO
COPY target/victor-0.0.1-SNAPSHOT.jar vao-app.jar
ENTRYPOINT ["java","-jar","/vao-app.jar"]