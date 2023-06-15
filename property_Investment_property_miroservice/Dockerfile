FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/property-service.jar property-service.jar
ENTRYPOINT ["java","-jar","/property-service.jar"]