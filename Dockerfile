FROM reg.dolplay.com/library/xh-baseimage-java:8
MAINTAINER conanca <imconan@gmail.com>

ADD target/spring-boot-sample-1.0-SNAPSHOT.jar app.jar

# Http port
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker-compose"]
