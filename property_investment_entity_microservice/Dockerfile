FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/entity-service.jar entity-service.jar
ENTRYPOINT ["java","-jar","/entity-service.jar"]