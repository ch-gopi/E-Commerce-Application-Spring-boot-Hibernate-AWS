FROM openjdk:17

#sudo apt-get update
#sudo apt-get install
#sudo apt-get install java

COPY target/productServiceSST9Mar-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]