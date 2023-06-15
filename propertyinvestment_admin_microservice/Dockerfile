FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/admin-service.jar admin-service.jar
ENTRYPOINT ["java","-jar","/admin-service.jar"]