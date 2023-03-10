FROM openjdk:8-jdk-alpine

ENV JAVA_OPTIONS -Xmx256m

EXPOSE 8081

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]