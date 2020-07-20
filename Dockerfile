FROM openjdk:11-jre

RUN mkdir /app
WORKDIR /app

ENTRYPOINT ["java","-jar","app.jar"]

COPY target/MckessonConsumer-0.0.1-SNAPSHOT.jar app.jar
