FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD build/libs/app.jar app.jar

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
