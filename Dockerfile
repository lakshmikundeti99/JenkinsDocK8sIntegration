FROM openjdk:8

EXPOSE 8080

ADD target/JenkinsDocK8sIntegration.jar JenkinsDocK8sIntegration.jar

ENTRYPOINT ["java","-jar","JenkinsDocK8sIntegration.jar"]

