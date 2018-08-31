FROM openjdk:8-jdk-alpine
ADD build/libs/microservice-demo-0.1.0.jar microservice-demo-0.1.0.jar
ENTRYPOINT ["java", "-jar", "microservice-demo-0.1.0.jar"]