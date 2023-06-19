FROM openjdk:8-jre-alpine
WORKDIR /app
COPY PetPlatform-1.0-SNAPSHOT.jar ./pet_platform.jar
ENTRYPOINT ["java", "-jar", "/app/pet_platform.jar.jar"]
