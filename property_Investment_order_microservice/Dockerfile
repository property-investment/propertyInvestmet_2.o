FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/order-service.jar order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]