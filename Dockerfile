FROM amazoncorretto:11-alpine-jdk
MAINTAINER PauloContrera
COPY target/Paulo-0.0.1-SNAPSHOT.jar  Paulo-app.jar
ENTRYPOINT ["java","-jar","/Paulo-app.jar"]