FROM openjdk:17-jdk-alpine
EXPOSE 8081
ADD target/springboot-k8s-crud.jar springboot-k8s-crud.jar
ENTRYPOINT ["java", "-jar", "/springboot-k8s-crud.jar"]