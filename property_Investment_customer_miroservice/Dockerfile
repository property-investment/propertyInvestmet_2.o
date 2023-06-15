FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/customer-service.jar customer-service.jar
ENTRYPOINT ["java","-jar","/customer-service.jar"]