FROM openjdk:8
ADD target/project3-0.0.1-SNAPSHOT.jar project3.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "project3.jar"]