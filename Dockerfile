FROM openjdk:8-jdk-alpine
ADD . /TechScreeningService
WORKDIR /TechScreeningService
CMD ["java", "-jar", "target/tech-screening-service-0.0.1-SNAPSHOT.jar"]