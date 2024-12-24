FROM openjdk:17-jdk-slim
WORKDIR /srv-portal
LABEL authors="Rennan Morais"
COPY target/srv-portal-0.0.1-SNAPSHOT.jar srv-portal.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "srv-portal.jar"]