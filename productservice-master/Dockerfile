FROM openjdk:17
LABEL authors="gopi"


COPY target/filename.jar /app/filename.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "filename.jar"]
