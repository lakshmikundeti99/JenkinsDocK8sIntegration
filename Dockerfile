FROM openjdk:8

EXPOSE 8080

ADD target/jenkins-integration.jar jenkins-integration.jar

ENTRYPOINT ["java","-jar","jenkins-integration.jar"]

