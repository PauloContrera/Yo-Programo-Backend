FROM amazoncorretto:11-alpine-jdk
MAINTAINER Paulo
COPY target/Paulo-0.0.1-SNAPSHOT.jar  PauloContrera-app.jar
ENTRYPOINT ["java","-jar","/PauloContrera-app.jar"]

